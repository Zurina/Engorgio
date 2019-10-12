/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaton;

/**
 *
 * @author Orchi
 */
public class Program {
    
    public static void main(String[] args) {
        
        Log log = new Log();
        
        log.addLog(Automaton.createLogEntryOfAction(1, Action.LOGIN));
        log.addLog(Automaton.createLogEntryOfAction(2, Action.LOGIN));
        log.addLog(Automaton.createLogEntryOfAction(3, Action.LOGIN));
        System.out.println(Automaton.listRunningInstances());
        
        log.addLog(Automaton.createLogEntryOfAction(1, Action.EDIT_ITEM));
        log.addLog(Automaton.createLogEntryOfAction(1, Action.LOGOUT));
        log.addLog(Automaton.createLogEntryOfAction(1, Action.EDIT_ITEM));
        System.out.println(Automaton.listRunningInstances());
        
        log.getLog().forEach(logEntry -> System.out.println(logEntry));
    }
    
}
