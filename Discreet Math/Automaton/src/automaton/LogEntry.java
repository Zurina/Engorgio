/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automaton;

import java.util.Date;

/**
 *
 * @author Orchi
 */
public class LogEntry {
    
    private Level level;
    private int systemId;
    private int instanceId;
    private Action action;
    private Date timestamp;
    private String description;

    public LogEntry() {
        
    }

    public LogEntry(Level level, int systemId, int instanceId, Action action, Date timestamp, String description) {
        this.level = level;
        this.systemId = systemId;
        this.instanceId = instanceId;
        this.action = action;
        this.timestamp = timestamp;
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "Level: " + this.level + 
                ", System ID: " + this.systemId + 
                ", Instance ID: " + this.instanceId + 
                ", Action: " + this.action + 
                ", Timestamp: " + this.timestamp.toString() + 
                ", Description: " + this.description; 
    }

    public int getInstanceId() {
        return instanceId;
    }
    
}

enum Level {
    INFORMATION,
    WARNING,
    ERROR
}

enum Action {
    LOGIN,
    LIST_ITEMS,
    EDIT_ITEM,
    LOGOUT
}
