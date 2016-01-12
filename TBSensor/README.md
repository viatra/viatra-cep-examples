Example Sensor Application for iOS
==================================

This is a simple example application to test the sensor capabilities of iOS devices.

Features:
- Measures data of various built-in movement sensors
- Display the measured data on 3 axes
- Transmits the measured data over wifi using the MQTT protocol

Deployment:
- Open the TBSensor.xcworkspace file to open the project in Xcode (Xcode 7 required)
- To deploy on a device you need to have a (free) registered Apple account set up in Xcode
- The current deployment target is iOS 8.1

Usage:
- MQTT tab: allows setting of broker address, and other preferences
- Graph tab: displays the measured data
- Text tab: displays the measured data in text only
- Double-tap the graph/text screen to start/stop measuring
