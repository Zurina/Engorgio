/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaton;

import java.util.HashMap;

/**
 *
 * @author Orchi
 */
public class StateModel {
    
    // map containing instance ID as key and whether instance is logged in or not as value
    public static HashMap<Integer, Boolean> state = new HashMap<Integer, Boolean>();
    
    public static void updateState(Integer instanceId, Boolean loggedIn) {
        state.put(instanceId, loggedIn);
    }
    
    public static boolean isInstanceLoggedIn(Integer id) {
        if (!state.containsKey(id)) updateState(id, false);
        return state.get(id);
    }
}


