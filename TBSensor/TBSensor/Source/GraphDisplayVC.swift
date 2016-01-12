//
//  ChartDisplayVC.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit

class GraphDisplayVC: DisplayVC {

    @IBOutlet weak var xGraphView: GraphView!
    @IBOutlet weak var yGraphView: GraphView!
    @IBOutlet weak var zGraphView: GraphView!
    lazy var graphViews: [GraphView] = { [unowned self] in
        return [self.xGraphView, self.yGraphView, self.zGraphView] }()
    
    var ptpValue: CGFloat
    @IBOutlet weak var ptpLabel: UILabel!
    @IBOutlet weak var ptpStepper: UIStepper!
    
    @IBOutlet weak var fpsLabel: UILabel!
    @IBOutlet weak var fpsStepper: UIStepper!
    
    @IBOutlet weak var typeTF: UITextField!
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------

    required init?(coder aDecoder: NSCoder) {
        let defaults = NSUserDefaults.standardUserDefaults()
        ptpValue = CGFloat(defaults.objectForKey(DefaultsKey.DisplayPTP.rawValue)?.floatValue ?? 8)
        
        super.init(coder: aDecoder)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    VIEW
    // --------------------------------------------------------------------------------------------

    override func viewDidLoad() {
        super.viewDidLoad()
        
        // setup Graphs
        for i in 0...2 {
            graphViews[i].sensor = sensor
            graphViews[i].coord = i==0 ? .X : (i==1 ? .Y : .Z)
            graphViews[i].vc = self
        }
        
        // setup PTP UI
        updatePTPLabel()
        ptpStepper.minimumValue = 1
        ptpStepper.maximumValue = 12
        ptpStepper.wraps = false
        ptpStepper.autorepeat = false
        ptpStepper.value = Double(ptpValue)
        ptpStepper.stepValue = 1.0
        
        // setup FPS UI
        updateFPSLabel()
        fpsStepper.minimumValue = 0
        fpsStepper.maximumValue = Double(sensor.niceFPSValues.count - 1)
        fpsStepper.wraps = false
        fpsStepper.autorepeat = false
        fpsStepper.value = Double(sensor.niceIntervals.indexOf(sensor.updateInterval)!)
        fpsStepper.stepValue = 1.0
        
        // setup SensorType UI
        let typePicker = UIPickerView()
        typePicker.dataSource = self
        typePicker.delegate = self
        typePicker.backgroundColor = UIColor.whiteColor()
        typeTF.inputView = typePicker
        typeTF.text = sensor.sensorType.rawValue
        typePicker.selectRow(SensorType.allCases.indexOf(sensor.sensorType)!, inComponent: 0, animated: false)
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
    
    @IBAction func ptpStepperValueChanged(sender: UIStepper) {
        ptpValue = CGFloat(sender.value)
        updatePTPLabel()
        graphViews.forEach({ $0.gravityLinesPath = nil })
        graphViews.forEach({ $0.setNeedsDisplay() })
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setFloat(Float(ptpValue), forKey: DefaultsKey.DisplayPTP.rawValue)
    }
    
    @IBAction func fpsStepperValueChanged(sender: UIStepper) {
        sensor.setFPSWithIndex(Int(sender.value))
        updateFPSLabel()
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setInteger(Int(sender.value), forKey: DefaultsKey.SensorFPSIndex.rawValue)
    }
    
    func sensorTypeValueChanged(newSensorType: SensorType) {
        let wasActive = sensor.sensorActive
        if wasActive { sensor.stopUpdates() }
        sensor.sensorType = newSensorType
        if wasActive { sensor.startUpdates() }
        
        typeTF.text = newSensorType.rawValue
        typeTF.resignFirstResponder()
        
        // store settings
        let defaults = NSUserDefaults.standardUserDefaults()
        defaults.setValue(newSensorType.rawValue, forKey: DefaultsKey.SensorType.rawValue)
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    override func handleSensorUpdate() {
        graphViews.forEach({ $0.setNeedsDisplay() })
    }
    
    override func resetDisplay() {
        graphViews.forEach({ $0.clearView() })
    }
    
    // --------------------------------------------------------------------------------------------

    func updatePTPLabel() {
        ptpLabel.text = "PTP = \(Int(ptpValue))"
    }
    
    func updateFPSLabel() {
        fpsLabel.text = "FPS = \(Int(sensor.currentFPS))"
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

extension GraphDisplayVC: UIPickerViewDelegate, UIPickerViewDataSource {
    func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return SensorType.allCases.count
    }
    
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return SensorType.allCases[row].rawValue
    }
    
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        sensorTypeValueChanged(SensorType.allCases[row])
    }
}