//
//  Common.swift
//  TBSensor
//
//  Copyright © 2015 rh12. All rights reserved.
//

import UIKit
import CoreMotion

// --------------------------------------------------------------------------------------------
// MARK:-    CONSTANTS
// --------------------------------------------------------------------------------------------

enum NotificationKey: String {
    case SensorDidUpdate
}

enum DefaultsKey: String {
    case SensorType
    case SensorFPSIndex
    case DisplayPTP
    
    case MQTTHostAddress
    case MQTTHostPort
    case MQTTTopicGroup
    case MQTTTopicSensor
    case MQTTPublishQOS
}


// --------------------------------------------------------------------------------------------
// MARK:-    TYPES
// --------------------------------------------------------------------------------------------

enum SensorType: String {
    case RawAcceleration
    case RawGyro
    case DMUserAcceleration
    case DMGravity
    case DMGyro
    case DMAttitude
    
    static let allCases = [SensorType.RawAcceleration, .RawGyro,
        .DMUserAcceleration, .DMGravity, .DMGyro, .DMAttitude]
}


// --------------------------------------------------------------------------------------------
// MARK:-    EXTENSIONS
// --------------------------------------------------------------------------------------------

extension Double {
    func toString(decimals: Int) -> String {
        return NSString(format: "%.\(decimals)f", self) as String
    }
}

extension Int {
    func toString(digits: Int, zeroPad: Bool = true) -> String {
        let pad = zeroPad ? "0" : ""
        return NSString(format: "%\(pad)\(digits)d", self) as String
    }
}

// --------------------------------------------------------------------------------------------

func + (lhs: CMAcceleration, rhs: CMAcceleration) -> CMAcceleration {
    return CMAcceleration(x: lhs.x + rhs.x, y: lhs.y + rhs.y, z: lhs.z + rhs.z)
}

func - (lhs: CMAcceleration, rhs: CMAcceleration) -> CMAcceleration {
    return CMAcceleration(x: lhs.x - rhs.x, y: lhs.y - rhs.y, z: lhs.z - rhs.z)
}
