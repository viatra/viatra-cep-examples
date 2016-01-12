//
//  Sensor.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit
import CoreMotion

let MaxNumberOfNodes = 260

class Sensor {
    private(set) var currentNode: Node = Node()
    private(set) var nodeHistory: [Node] = []        // [0] = newest
    private(set) var minValues: Node = Node()
    private(set) var maxValues: Node = Node()
    private(set) var startTimestamp: NSTimeInterval = 0     // first CMLogItem.timestamp (since device boot)
    private(set) var startDate: NSTimeInterval = 0          // date at startTimestamp (since 1970)
    
    let motionManager: CMMotionManager
    var sensorType: SensorType
    var sensorAvailable: Bool {
        switch sensorType {
        case .RawAcceleration:
            return motionManager.accelerometerAvailable
        case .RawGyro:
            return motionManager.gyroAvailable
        default:
            return motionManager.deviceMotionAvailable
        }
    }
    var sensorActive: Bool {
        switch sensorType {
        case .RawAcceleration:
            return motionManager.accelerometerActive
        case .RawGyro:
            return motionManager.gyroActive
        default:
            return motionManager.deviceMotionActive
        }
    }
    
    var updateInterval: Double = 0.01
    let niceIntervals: [Double] = [0.1, 0.05, 0.04, 0.03125, 0.015625, 0.0125, 0.01]
    let niceFPSValues: [Double] = [10, 20, 25, 32, 64, 80, 100]
    var currentFPS: Double {
        return niceFPSValues[niceIntervals.indexOf(updateInterval)!]
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------

    init() {
        motionManager = CMMotionManager()
        
        let defaults = NSUserDefaults.standardUserDefaults()
        
        let defaultSensorType = SensorType.DMUserAcceleration
        let typeString = defaults.stringForKey(DefaultsKey.SensorType.rawValue) ?? defaultSensorType.rawValue
        sensorType = SensorType(rawValue: typeString) ?? defaultSensorType
        setFPSWithIndex(defaults.objectForKey(DefaultsKey.SensorFPSIndex.rawValue)?.integerValue ?? 4)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------
    
    func startStopUpdates() {
        if sensorActive {
            stopUpdates()
        } else {
            startUpdates()
        }
    }
    
    func startUpdates() {
        guard sensorAvailable else { return }
        print("--- Updates will START")
        
        startTimestamp = 0
                
        let queue = NSOperationQueue.currentQueue()!
        switch sensorType {
        case .RawAcceleration:
            // Acceleration Data
            motionManager.startAccelerometerUpdatesToQueue(queue, withHandler: {
                [unowned self] data, error in
                if let data = data {
                    self.processNode(Node(acceleration: data.acceleration, timestamp: data.timestamp))
                }
            })
        case .RawGyro:
            // Gyroscope Data
            motionManager.startGyroUpdatesToQueue(queue, withHandler: {
                [unowned self] data, error in
                if let data = data {
                    self.processNode(Node(rotationRate: data.rotationRate, timestamp: data.timestamp))
                }
            })
        default:
            // DeviceMotion Data
            let refFrame = CMAttitudeReferenceFrame.XArbitraryZVertical
            motionManager.startDeviceMotionUpdatesUsingReferenceFrame(refFrame, toQueue: queue, withHandler: {
                [unowned self] data, error in
                
                if let data = data {
                    let node: Node
                    switch self.sensorType {
                    case .DMUserAcceleration:
                        node = Node(acceleration: data.userAcceleration, timestamp: data.timestamp)
                    case .DMGravity:
                        node = Node(acceleration: data.gravity, timestamp: data.timestamp)
                    case .DMGyro:
                        node = Node(rotationRate: data.rotationRate, timestamp: data.timestamp)
                    case .DMAttitude:
                        node = Node(attitude: data.attitude, timestamp: data.timestamp)
                    default:
                        node = Node() // dummy
                    }
                    self.processNode(node)
                }
            })
        }
    }
    
    func stopUpdates() {
        switch sensorType {
        case .RawAcceleration:
            motionManager.stopAccelerometerUpdates()
        case .RawGyro:
            motionManager.stopGyroUpdates()
        default:
            motionManager.stopDeviceMotionUpdates()
        }
        print("--- Updates did STOP")
    }
    
    // --------------------------------------------------------------------------------------------
    
    private func processNode(newNode: Node) {
        // set current
        currentNode = newNode
        
        // store starting values
        if startTimestamp == 0 {
            startTimestamp = currentNode.timestamp
            startDate = NSDate().timeIntervalSince1970  // should be added to startTS here???
            print("x: \(newNode.x)   y: \(newNode.y)   z: \(newNode.z)")
        }
        
        // set min/max
        for c in NodeCoord.allCases {
            if currentNode[c] < minValues[c] {
                minValues[c] = currentNode[c]
            }
            if currentNode[c] > maxValues[c] {
                maxValues[c] = currentNode[c]
            }
        }
        
        // add to History
        if nodeHistory.count == MaxNumberOfNodes {
            nodeHistory.removeLast()
        }
        nodeHistory.insert(newNode, atIndex: 0)
        
        // notify
        NSNotificationCenter.defaultCenter()
            .postNotificationName(NotificationKey.SensorDidUpdate.rawValue, object: self)
    }
    
    func resetNodes() {
        currentNode = Node()
        nodeHistory = []
        minValues = Node()
        maxValues = Node()
    }
    
    // --------------------------------------------------------------------------------------------

    func setFPSWithIndex(index: Int) {
        updateInterval = niceIntervals[index]
        
        motionManager.accelerometerUpdateInterval = updateInterval
        motionManager.gyroUpdateInterval = updateInterval
        motionManager.deviceMotionUpdateInterval = updateInterval
    }
}


// --------------------------------------------------------------------------------------------
// MARK:-    [---- EXTENSIONS ----]
// --------------------------------------------------------------------------------------------

