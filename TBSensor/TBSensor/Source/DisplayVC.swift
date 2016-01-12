//
//  DisplayVC.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit

class DisplayVC: UIViewController {

    weak var sensor: Sensor!
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------

//    required init?(coder aDecoder: NSCoder) {
//
//        super.init(coder: aDecoder)
//    }
    
    deinit {
        NSNotificationCenter.defaultCenter().removeObserver(self)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    VIEW
    // --------------------------------------------------------------------------------------------

    override func viewDidLoad() {
        super.viewDidLoad()
        
        sensor = AppDelegate.sharedAppDelegate().sensor!
        NSNotificationCenter.defaultCenter().addObserver(
            self, selector: "handleSensorUpdate", name: NotificationKey.SensorDidUpdate.rawValue, object: nil)
        resetDisplay()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // --------------------------------------------------------------------------------------------
    
//    override func viewWillAppear(animated: Bool) {
//        super.viewWillAppear(animated)
//        
//    }
    
//    override func viewDidAppear(animated: Bool) {
//        super.viewDidAppear(animated)
//        
//    }
    
//    override func viewWillDisappear(animated: Bool) {
//        super.viewWillDisappear(animated)
//        
//    }
    
//    override func viewDidDisappear(animated: Bool) {
//        super.viewDidDisappear(animated)
//        
//    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    ACTIONS
    // --------------------------------------------------------------------------------------------
    
    @IBAction func clearButtonPressed(sender: UIButton) {
        sensor.resetNodes()
        resetDisplay()
    }
    
    @IBAction func doubleTapDisplay(sender: UITapGestureRecognizer) {
        sensor.startStopUpdates()
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    func handleSensorUpdate() {
        // subclass should override
    }
    
    func resetDisplay() {
        // subclass should override
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

