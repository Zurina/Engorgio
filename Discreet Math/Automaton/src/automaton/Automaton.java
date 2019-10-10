/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaton;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Orchi
 */
public class Automaton {

    
    public static List listRunningInstances() {
	return StateModel.state.entrySet().stream()
		.filter(instance -> instance.getValue() == true)
		.map(instance -> instance.getKey())
		.collect(Collectors.toList());
    }
    
    public static LogEntry createLogEntryOfAction(Integer instanceId, Action action) {
        Integer systemId = 100; // Just something..
        Level level = null;
        String msg = null;
        LogEntry logEntry = null;
        switch(action) {
            case LOGIN: {
                boolean permitted = !StateModel.isInstanceLoggedIn(instanceId) ? true : false;
                if (permitted) {
                    level = Level.INFORMATION;
                    msg = "Action: Login - Permitted";
                    StateModel.updateState(instanceId, true);
                } else {
                    level = Level.WARNING;
                    msg = "Action: Login - not permitted. You're already logged in";
                }
            }
            break;
            case EDIT_ITEM: {
                boolean permitted = StateModel.isInstanceLoggedIn(instanceId) ? true : false;
                if (permitted) {
                    level = Level.INFORMATION;
                    msg = "Action: Edit_Item - Permitted";
                } else {
                    level = Level.WARNING;
                    msg = "Action: Edit_Item - not permitted. You're not logged in";
                }
            }
            break;
            case LIST_ITEMS: {
                boolean permitted = StateModel.isInstanceLoggedIn(instanceId) ? true : false;
                
                if (permitted) {
                    level = Level.INFORMATION;
                    msg = "Action: List_Items - Permitted";
                } else {
                    level = Level.WARNING;
                    msg = "Action: List_Items - not permitted. You're not logged in";
                }
            }
            break;
            case LOGOUT: {
                boolean permitted = StateModel.isInstanceLoggedIn(instanceId) ? true : false;
                if (permitted) {
                    level = Level.INFORMATION;
                    msg = "Action: Logout - Permitted";
                    StateModel.updateState(instanceId, false);
                } else {
                    level = Level.WARNING;
                    msg = "Action: Logout - not permitted. You're not logged in";
                }
            }
            break;
            default: {
                boolean permitted = false;
                msg = "None-matching action. You stupid";
            }
        }
        return new LogEntry(level, systemId, instanceId, action, new Date(), msg);
    }
}
