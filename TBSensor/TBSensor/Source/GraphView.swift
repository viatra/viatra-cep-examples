//
//  GraphView.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit

//@IBDesignable
class GraphView: UIView {
    
    weak var sensor: Sensor!
    var coord: NodeCoord!
    weak var vc: GraphDisplayVC!
    
    lazy var zeroPoint: CGPoint = { [unowned self] in
        return CGPoint(x: 0.5, y: self.bounds.height/2 + 0.5) }()
    
    var dataColor = UIColor.redColor()
    var dataLineWidth: CGFloat = 1.5
    var shouldDrawGravityLines = true
    
    var axesPath: UIBezierPath?
    var gravityLinesPath: UIBezierPath?
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    INIT
    // --------------------------------------------------------------------------------------------
    
//    required init?(coder aDecoder: NSCoder) {
//        super.init(coder: aDecoder)
//    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    DRAWING
    // --------------------------------------------------------------------------------------------

    override func drawRect(rect: CGRect) {
        drawAxes()
        if shouldDrawGravityLines {
            drawGravityLines()
        }
        drawData()
    }
    
    // --------------------------------------------------------------------------------------------
    
    private func drawData() {
        guard let sensor = sensor where sensor.nodeHistory.count > 0 else { return }
        
        let yRatio = bounds.height / vc.ptpValue
        func graphPointAtIndex(i: Int) -> CGPoint {
            let dataValue = CGFloat(sensor.nodeHistory[i][coord])
            return CGPoint(
//                x: zeroPoint.x + CGFloat(i),                        // Left to Right
                x: zeroPoint.x + CGFloat(MaxNumberOfNodes - i),     // Right to Left
                y: zeroPoint.y + yRatio * dataValue)
        }
        
        let dataPath = UIBezierPath()
        dataPath.moveToPoint(graphPointAtIndex(0))
        for i in 1..<sensor.nodeHistory.count {
            dataPath.addLineToPoint(graphPointAtIndex(i))
        }
        
        dataPath.lineWidth = dataLineWidth
        dataColor.setStroke()
        dataPath.stroke()
    }

    private func drawAxes() {
        UIColor.blackColor().setStroke()
        
        if let path = axesPath {
            path.stroke()
            return
        }
        
        // create & draw Path
        let path = UIBezierPath()
        path.lineWidth = 1.0
        path.moveToPoint(zeroPoint)
        path.addLineToPoint(CGPoint(x: bounds.width, y: zeroPoint.y))
        path.moveToPoint(CGPoint(x: zeroPoint.x, y: bounds.height))
        path.addLineToPoint(CGPoint(x: zeroPoint.x, y: 0.0))
        path.stroke()
        
        axesPath = path
    }
    
    private func drawGravityLines() {
        UIColor.blueColor().setStroke()
        
        if let path = gravityLinesPath {
            path.stroke()
            return
        }
        
        let yGravity = bounds.height / vc.ptpValue
        let path = UIBezierPath()
        path.lineWidth = 0.25
        path.moveToPoint(CGPoint(x: zeroPoint.x, y: zeroPoint.y + yGravity))
        path.addLineToPoint(CGPoint(x: bounds.width, y: zeroPoint.y + yGravity))
        path.moveToPoint(CGPoint(x: zeroPoint.x, y: zeroPoint.y - yGravity))
        path.addLineToPoint(CGPoint(x: bounds.width, y: zeroPoint.y - yGravity))
        path.stroke()
        
        gravityLinesPath = path
    }
    
    
    // --------------------------------------------------------------------------------------------
    // MARK:-    GENERAL
    // --------------------------------------------------------------------------------------------

    func clearView() {
        setNeedsDisplay()
    }

}


// --------------------------------------------------------------------------------------------
// MARK:-    [---- EXTENSIONS ----]
// --------------------------------------------------------------------------------------------

