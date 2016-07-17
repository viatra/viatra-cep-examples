# Demo webUI usage: 

## Control topics: 
 
* Lock Position:
  * Topics: lock/[1-4]/pos_change
  * Message format: {position: [x]} where x: 0-5
  * Function: changes the position of the i-th lock to _position_
* Lock State: 
  * Topic: lock/all/state
  * Message format: {state: [s]} where s: "init" / "incorrect_pass" / "correct_pass"
  * Function: changes the state to _s_ 
    * init: transform all locks to _position 0_ and state to _locked_
    * incorrect_pass: change state to _locked_
    * correct_pass: change state to _unlocked_

