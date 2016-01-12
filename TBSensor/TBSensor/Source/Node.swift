//
//  Node.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit
import CoreMotion


struct Node {
    var x: Double = 0
    var y: Double = 0
    var z: Double = 0
    var timestamp: NSTimeInterval = 0
    
    subscript(c: NodeCoord) -> Double {
        get {
            switch c {
            case .X: return x
            case .Y: return y
            case .Z: return z
            }
        }
        set {
            switch c {
            case .X: x = newValue
            case .Y: y = newValue
            case .Z: z = newValue
            }
        }
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------

    init(x: Double, y: Double, z: Double, timestamp: NSTimeInterval) {
        self.x = x;  self.y = y;  self.z = z
        self.timestamp = timestamp
    }
    
    // --------------------------------------------------------------------------------------------
    
    init(x: Double, y: Double, z: Double) {
        self.init(x: x, y: y, z: z, timestamp: 0)
    }
    
    init() {
        self.init(x: 0, y: 0, z: 0, timestamp: 0)
    }
    
    // --------------------------------------------------------------------------------------------

    init(acceleration: CMAcceleration, timestamp: NSTimeInterval) {
        self.init(x: acceleration.x, y: acceleration.y, z: acceleration.z, timestamp: timestamp)
    }
    
    init(rotationRate: CMRotationRate, timestamp: NSTimeInterval) {
        self.init(x: rotationRate.x, y: rotationRate.y, z: rotationRate.z, timestamp: timestamp)
    }
    
    init(attitude: CMAttitude, timestamp: NSTimeInterval) {
        self.init(x: attitude.pitch, y: attitude.roll, z: attitude.yaw, timestamp: timestamp)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    
}


// --------------------------------------------------------------------------------------------
// MARK:-    FUNCTIONS
// --------------------------------------------------------------------------------------------

func * (lhs: Node, rhs: Double) -> Node {
    return Node(x: lhs.x * rhs, y: lhs.y * rhs, z: lhs.z * rhs, timestamp: lhs.timestamp)
}

func *= (inout lhs: Node, rhs: Double) {
    lhs.x = lhs.x * rhs
    lhs.y = lhs.y * rhs
    lhs.z = lhs.z * rhs
}


// --------------------------------------------------------------------------------------------
// MARK:-    TYPES
// --------------------------------------------------------------------------------------------

enum NodeCoord {
    case X, Y, Z
    static let allCases: [NodeCoord] = [.X, .Y, .Z]
}
