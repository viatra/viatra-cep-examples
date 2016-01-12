//
//  MQTTHandler.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit
import Moscapsule


class MQTTHandler: NSObject {
    
    weak var sensor: Sensor?
    weak var vc: ConnectionVC?
    
    lazy var mqttClient: MQTTClient = self.initClient()
    let mqttConfig: MQTTConfig
    var topicData: String = ""
    var topicStatus: String = ""
    var publishQOS: Int = 0
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------
    
    init(host: String, port: Int) {
        // enable debug log
        // Pods.xcodeproj/PreprocessorMacros/DEBUG=1 (disable: remove(!) it)

        mqttConfig = MQTTConfig(clientId: "iosTBSensor", host: host, port: Int32(port), keepAlive: 60)
        
        super.init()
        
        // lazy init in Phase2
        mqttClient.isConnected
        
        NSNotificationCenter.defaultCenter().addObserver(
            self, selector: "handleSensorUpdate", name: NotificationKey.SensorDidUpdate.rawValue, object: nil)
    }
    
    private func initClient() -> MQTTClient {
        // callbacks
        mqttConfig.onConnectCallback = { [unowned self] returnCode in
            NSLog("Connect return code: \(returnCode.description)")
            if returnCode == .Success {
                dispatch_async(dispatch_get_main_queue()) {
                    self.vc?.didConnectSuccesfully(self)
                }
            }
        }
        mqttConfig.onDisconnectCallback = { [unowned self] reasonCode in
            NSLog("Disconnect reason code: \(reasonCode.description)")
            if reasonCode == .Unexpected {
                self.didDisconnectUnexpectedly()
            }
        }
        //        mqttConfig.onPublishCallback = { messageId in
        //            NSLog("published (mid=\(messageId))")
        //        }
        //        mqttConfig.onMessageCallback = { mqttMessage in
        //            NSLog("MQTT Message received: payload=\(mqttMessage.payloadString)")
        //        }
        
        // create new MQTT Connection
        return MQTT.newConnection(mqttConfig)
    }
    
    deinit {
        NSNotificationCenter.defaultCenter().removeObserver(self)
        
        // disconnect
        mqttClient.disconnect()
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    SETUP
    // --------------------------------------------------------------------------------------------
    
    func setTopicsFor(group groupID: String, sensor sensorID: String) {
        let topicPath = "sensor/\(groupID)/\(sensorID)/"
        topicData = topicPath + "data"            // measured data
        topicStatus = topicPath + "status"        // metadata
    }
    
    class func dataTopicFor(group groupID: String, sensor sensorID: String) -> String {
        return "sensor/\(groupID)/\(sensorID)/data"
    }
    
    class func statusTopicFor(group groupID: String, sensor sensorID: String) -> String {
        return "sensor/\(groupID)/\(sensorID)/status"
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    func handleSensorUpdate() {
        let node = sensor!.currentNode * 1000   // mG
        
        // calculate absolute timestamp (since 1970)
        let ts = (node.timestamp - sensor!.startTimestamp) + sensor!.startDate
        let tsInt = Int(ts * 1000.0)
        
        // format: {"x":xValue,"y":yValue,"z":zValue,"t":timestamp}
        //      (use double quotes!!!)
        //   values: double/float
        //   timestamp: long [ms] since 1970.01.01
        let data = "{\"x\":\(node.x),\"y\":\(node.y),\"z\":\(node.z),\"t\":\(tsInt)}"
        //print(data)
        publishData(data)
    }
    
    // --------------------------------------------------------------------------------------------
    
    func publishData(message: String) {
        mqttClient.publishString(message, topic: topicData, qos: Int32(publishQOS), retain: false)
    }
    
    func publishStatus(message: String) {
        mqttClient.publishString(message, topic: topicStatus, qos: 2, retain: false)
    }
    
    func subscribeToTopic(topic: String) {
        mqttClient.subscribe("subscribe/\(topic)", qos: 2)
    }
    
    func didDisconnectUnexpectedly() {
        print("func: \(__FUNCTION__)")
        guard vc?.mqttHandler != nil else { return }
        
        // update UI
        print("will RECONNECT")
        /// TODO
        
        // reconnect
        mqttClient = initClient()
    }
}


// --------------------------------------------------------------------------------------------
// MARK:-    [---- EXTENSIONS ----]
// --------------------------------------------------------------------------------------------
