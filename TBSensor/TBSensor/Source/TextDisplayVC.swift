//
//  MainVC.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit

class TextDisplayVC: DisplayVC {
    
    @IBOutlet weak var xLabel: UILabel!
    @IBOutlet weak var yLabel: UILabel!
    @IBOutlet weak var zLabel: UILabel!
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------
    
//    required init?(coder aDecoder: NSCoder) {
//        super.init(coder: aDecoder)
//    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    VIEW
    // --------------------------------------------------------------------------------------------
    
    override func viewDidLoad() {
        super.viewDidLoad()
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
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------
    
    override func handleSensorUpdate() {
//        print("    textVC: \(__FUNCTION__)")
        let dec = 2
        
        func stringForCoord(c: NodeCoord) -> String {
            return sensor.currentNode[c].toString(dec)
                + "       [  " + sensor.minValues[c].toString(dec)
                + "  :  " + sensor.maxValues[c].toString(dec)
                + "  ]"
        }
        
        xLabel.text = stringForCoord(.X)
        yLabel.text = stringForCoord(.Y)
        zLabel.text = stringForCoord(.Z)
    }
    
    override func resetDisplay() {
        xLabel.text = "0.0"
        yLabel.text = "0.0"
        zLabel.text = "0.0"
    }
        
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    NAVIGATION
    // --------------------------------------------------------------------------------------------
    
    //    // In a storyboard-based application, you will often want to do a little preparation before navigation
    //    override func prepareForSegue(segue: UIStoryboardSegue, sender: AnyObject?) {
    //        // Get the new view controller using segue.destinationViewController.
    //        // Pass the selected object to the new view controller.
    //    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    TOUCHES
    // --------------------------------------------------------------------------------------------
    
    
}


// --------------------------------------------------------------------------------------------
// MARK:-    [---- EXTENSIONS ----]
// --------------------------------------------------------------------------------------------

