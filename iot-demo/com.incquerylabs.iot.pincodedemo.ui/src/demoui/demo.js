var mqttBrokerLocation = {
    hostname : "localhost",
    port : 9001
}

var mqttClient;
var mqttTopicPosChange1 = "lock/1/pos_change"; // {position: 1-5}
var mqttTopicPosChange2 = "lock/2/pos_change";
var mqttTopicPosChange3 = "lock/3/pos_change";
var mqttTopicPosChange4 = "lock/4/pos_change";
var mqttTopicLockingState = "lock/all/state"; // // { state: "init" / "incorrect_pass" / "correct_pass" }

function CepLock(canvas){
    console.log("New CepLock object created");
}

CepLock.prototype.init = function () {
    this.initMqtt();
};

CepLock.prototype.lastHighlightedHeader = undefined;

////////
// MQTT
CepLock.prototype.initMqtt = function () {
    mqttClient = new Paho.MQTT.Client(mqttBrokerLocation.hostname, Number(mqttBrokerLocation.port), "cepLockClient");

    // set callback handlers
    mqttClient.onConnectionLost = this.mqttOnConnectionLost;
    mqttClient.onMessageArrived = this.mqttOnMessageArrived;

    // connect the client
    mqttClient.connect({onSuccess:this.mqttOnConnect, userName: "", password: "", useSSL: false});
};

CepLock.prototype.mqttOnConnect = function() {
    console.log("MQTTConnect");

    // Subscribe topics
    mqttClient.subscribe(mqttTopicPosChange1);
    mqttClient.subscribe(mqttTopicPosChange2);
    mqttClient.subscribe(mqttTopicPosChange3);
    mqttClient.subscribe(mqttTopicPosChange4);
    mqttClient.subscribe(mqttTopicLockingState);
}

// called when the client loses its connection
CepLock.prototype.mqttOnConnectionLost = function(responseObject) {
    if (responseObject.errorCode !== 0) {
        console.log("@@@ MQTTConnectionLost: "+responseObject.errorMessage);

        this.initMqtt();
    }
}

// called when a message arrives
CepLock.prototype.mqttOnMessageArrived = function(message) {
    var topic = message.destinationName;

    function parseJSONMessages(msgSource, message) {
        var parsedData = undefined;
        try {
            var jsonMsg = message.payloadString;
            parsedData = JSON.parse(jsonMsg);
            console.debug("Message arrived "+msgSource+":" + JSON.stringify(jsonMsg));
        } catch (err) {
            console.error("ERROR: " + err);
            console.error("Invalid message: " + message.payloadString);
        }
        return parsedData;
    }


    function changeSensorPosition(id, newPosition) {
        var div = $("#"+id);
        var ledDiv = $("#"+id + " div");
        var text = $("#"+id + " span");

        // Invaslid position?
        if( newPosition == 0 || newPosition == 1 || newPosition == 2 || newPosition == 3 || newPosition == 4 || newPosition == 5){
            div.removeClass(); // Remove all css classes
            div.addClass("lock-base-style");
            text.text(newPosition);
        }

        switch(newPosition){
            case 0:
                div.addClass("lock-normal");
                ledDiv.removeClass("off"); // show led
                break;
            case 1:
                div.addClass("lock-standing");
                ledDiv.addClass("off");
                break;
            case 2:
                div.addClass("lock-lateral");
                ledDiv.addClass("off");
                break;
            case 3:
                div.addClass("lock-lateral");
                ledDiv.addClass("off");
                break;
            case 4:
                div.addClass("lock-normal");
                ledDiv.addClass("off");
                break;
            case 5:
                div.addClass("lock-standing");
                ledDiv.addClass("off");
                break;
            default: console.error("Invalid newPosition of " + id)
        }
    }

    function highlightLastSetHeader(position) {
        // Remove all highlight
        removeArrows();
        // Add highlight class to last marked header
        $("#lock-arrow-" + position).addClass("arrow-active");
    }

    function removeArrows(){
        $(".arrow-active").removeClass("arrow-active");
    }

    var jsonMsg = parseJSONMessages(topic, message);
    switch (topic) {
        case mqttTopicPosChange1:
            if(jsonMsg.hasOwnProperty("position")){
                changeSensorPosition("lock-1", jsonMsg.position);
                highlightLastSetHeader(1);
            }else{
                console.error("Invalid PositionChange message format")
            }
            break;
        case mqttTopicPosChange2:
            if(jsonMsg.hasOwnProperty("position")){
                changeSensorPosition("lock-2", jsonMsg.position);
                highlightLastSetHeader(2);
            }else{
                console.error("Invalid PositionChange message format")
            }
            break;
        case mqttTopicPosChange3:
            if(jsonMsg.hasOwnProperty("position")){
                changeSensorPosition("lock-3", jsonMsg.position);
                highlightLastSetHeader(3);
            }else{
                console.error("Invalid PositionChange message format")
            }
            break;
        case mqttTopicPosChange4:
            if(jsonMsg.hasOwnProperty("position")){
                changeSensorPosition("lock-4", jsonMsg.position);
                highlightLastSetHeader(4);
            }else{
                console.error("Invalid PositionChange message format")
            }
            break;
        case mqttTopicLockingState:
            if(jsonMsg.hasOwnProperty("state")){
                if(jsonMsg.state == "correct_pass"){
                    $("#lock-state").text("UNLOCKED");
                    $("#lock-table").removeClass("locked").addClass("unlocked");
                }else if(jsonMsg.state == "incorrect_pass"){
                    // incorrect_pass
                    $("#lock-state").text("LOCKED");
                    $("#lock-table").removeClass("unlocked").addClass("locked");

                    // Flashing
                    $("#lock-state-p").removeClass("flashing");

                    setTimeout(function() {
                        $("#lock-state-p").addClass("flashing"); // have to wait 100ms for animation...
                    }, 100);
                }else if(jsonMsg.state == "init"){
                    // Remove arrows
                    removeArrows()

                    // Change state message and style
                    $("#lock-state").text("LOCKED");
                    $("#lock-table").removeClass("unlocked").addClass("locked");

                    // Reset positions
                    for(lockID in [1,2,3,4,5]){
                        changeSensorPosition("lock-" + lockID, 0);
                    }
                }
            }else{
                console.error("Invalid LockingState message format")
            }
            break;
        default: console.error("Invalid topic: " + topic);
    }


}
