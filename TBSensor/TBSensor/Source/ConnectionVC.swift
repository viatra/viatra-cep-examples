//
//  ConnectionVC.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit

class ConnectionVC: UIViewController {

    var mqttHandler: MQTTHandler?
    
    // TODO: ClientID
    @IBOutlet weak var hostAddressTF: UITextField!
    @IBOutlet weak var hostPortTF: UITextField!
    @IBOutlet weak var hostURLLabel: UILabel!
    @IBOutlet weak var hostStatusLabel: UILabel!
    @IBOutlet weak var connectButton: UIButton!
    @IBOutlet weak var topicGroupTF: UITextField!
    @IBOutlet weak var topicSensorTF: UITextField!
    @IBOutlet weak var topicDataLabel: UILabel!
    @IBOutlet weak var topicStatusLabel: UILabel!
    @IBOutlet weak var publishQOSControl: UISegmentedControl!
    
    var hostURL: String {
        return "tcp://\(hostAddressTF.text ?? ""):\(hostPortTF.text ?? "")"
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------

//    required init?(coder aDecoder: NSCoder) {
//
//        super.init(coder: aDecoder)
//    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    VIEW
    // --------------------------------------------------------------------------------------------

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // set default values
        let defaults = NSUserDefaults.standardUserDefaults()
        
        // "192.168.0.200"      // IncQuery broker
        // "iot.eclipse.org"    // public test broker (no websocket)
        // "192.168.0.100"      // dockerized local broker
        hostAddressTF.text = defaults.stringForKey(DefaultsKey.MQTTHostAddress.rawValue) ?? "192.168.0.100"
        hostPortTF.text = defaults.stringForKey(DefaultsKey.MQTTHostPort.rawValue) ?? "1883"
        hostURLLabel.text = hostURL
        hostStatusLabel.text = ""
        connectButton.layer.cornerRadius = 8
        connectButton.layer.borderWidth = 0.75
        updateConnectButton(false)
        
        topicGroupTF.text = defaults.stringForKey(DefaultsKey.MQTTTopicGroup.rawValue) ?? "iosDevice"
        topicSensorTF.text = defaults.stringForKey(DefaultsKey.MQTTTopicSensor.rawValue) ?? "sensor0"
        updateTopicLabels()
        
        publishQOSControl.selectedSegmentIndex = defaults.objectForKey(DefaultsKey.MQTTPublishQOS.rawValue)?.integerValue ?? 0
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    ACTIONS
    // --------------------------------------------------------------------------------------------
    
    @IBAction func connectButtonPressed(sender: UIButton) {
        // resign firstResponder
         view.endEditing(false)
        
        if mqttHandler == nil {
            // try to CONNECT
            connect()
        } else {
            // DISCONNECT
            disconnect()
        }
    }
    
    @IBAction func didEndEditingHostTF(sender: UITextField) {
        // update UI
        hostURLLabel.text = hostURL
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setValue(hostAddressTF.text, forKey: DefaultsKey.MQTTHostAddress.rawValue)
        defaults.setValue(hostPortTF.text, forKey: DefaultsKey.MQTTHostPort.rawValue)
    }
    
    @IBAction func didEndEditingTopicTF(sender: UITextField) {
        updateMQTTTopics()
        
        // update UI
        updateTopicLabels()
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setValue(topicGroupTF.text, forKey: DefaultsKey.MQTTTopicGroup.rawValue)
        defaults.setValue(topicSensorTF.text, forKey: DefaultsKey.MQTTTopicSensor.rawValue)
    }
    
    @IBAction func publishQOSValueChanged(sender: UISegmentedControl) {
        updateMQTTPublishQOS()
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setInteger(sender.selectedSegmentIndex, forKey: DefaultsKey.MQTTPublishQOS.rawValue)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    func connect() {
        guard let address = hostAddressTF.text, pString = hostPortTF.text, port = Int(pString) else {
            /// invalid Host Adress or Port
            return
        }
        
        mqttHandler = MQTTHandler(host: address, port: port)
        mqttHandler!.vc = self
        mqttHandler!.sensor = AppDelegate.sharedAppDelegate().sensor!
        updateMQTTTopics()
        updateMQTTPublishQOS()
        
        hostStatusLabel.textColor = UIColor.grayColor()
        hostStatusLabel.text = "CONNECTING..."
        updateConnectButton(true)
        hostAddressTF.enabled = false
        hostPortTF.enabled = false
    }
    
    func didConnectSuccesfully(handler: MQTTHandler) {
        hostStatusLabel.textColor = UIColor(red: 0, green: 0.8, blue: 0, alpha: 1)
        hostStatusLabel.text = "CONNECTED"
    }
    
    func disconnect() {
        mqttHandler = nil
        
        updateConnectButton(false)
        hostStatusLabel.text = ""
        hostAddressTF.enabled = true
        hostPortTF.enabled = true
    }
    
    // --------------------------------------------------------------------------------------------
    
    func updateMQTTTopics() {
        let groupID = topicGroupTF.text ?? ""
        let sensorID = topicSensorTF.text ?? ""
        mqttHandler?.setTopicsFor(group: groupID, sensor: sensorID)
    }
    
    func updateMQTTPublishQOS() {
        mqttHandler?.publishQOS = publishQOSControl.selectedSegmentIndex
    }
    
    // --------------------------------------------------------------------------------------------
    
    func updateConnectButton(connected: Bool) {
        let title = connected ? "Disconnect" : "Connect"
        let color = connected ? UIColor.redColor() : UIColor(red: 0, green: 122/255, blue: 1, alpha: 1)
        
        connectButton.setTitle(title, forState: .Normal)
        connectButton.setTitleColor(color, forState: .Normal)
        connectButton.layer.borderColor = color.CGColor
        
    }
    
    func updateTopicLabels() {
        let groupID = topicGroupTF.text ?? ""
        let sensorID = topicSensorTF.text ?? ""
        topicDataLabel.text = MQTTHandler.dataTopicFor(group: groupID, sensor: sensorID)
        topicStatusLabel.text = MQTTHandler.statusTopicFor(group: groupID, sensor: sensorID)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    NAVIGATION
    // --------------------------------------------------------------------------------------------

//    // In a storyboard-based application, you will often want to do a little preparation before navigation
//    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
//        // Get the new view controller using segue.destinationViewController.
//        // Pass the selected object to the new view controller.
//    }

}


// --------------------------------------------------------------------------------------------
// MARK:-    [---- EXTENSIONS ----]
// --------------------------------------------------------------------------------------------

extension ConnectionVC: UITextFieldDelegate {
    func textFieldShouldReturn(textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
}