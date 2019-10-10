/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Orchi
 */
public class Log {
    
    private List<LogEntry> log = new ArrayList<>();
    
    public void addLog(LogEntry logEntry) {
        log.add(logEntry);
    }
    
    public List<LogEntry> getLog() {
        return this.log;
    }
    
}
