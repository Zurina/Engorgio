/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author Orchi
 */
public class State {
    
    Map<String, ArrayList<Boolean>> booleans;
    Map<String, ArrayList<Integer>> integers;

    public State() {
        this.booleans = new HashMap<String, ArrayList<Boolean>>();
        this.integers = new HashMap<String, ArrayList<Integer>>();
    }
    
    public boolean isVariableBoolean(String name) {
        return booleans.containsKey(name);
    }
    
    public boolean isVariableInteger(String name) {
        return integers.containsKey(name);
    }
    
    public Integer getValueOfIntVariable(String name) {
        ArrayList<Integer> list = integers.get(name);
        return list.get(list.size() - 1);
    }
    public Boolean getValueOfBoolVariable(String name) {
        ArrayList<Boolean> list = booleans.get(name);
        return list.get(list.size() - 1);
    }
    
    public void putBoolean(String name, boolean value) {
        if (!booleans.containsKey(name))
            System.err.println(name + "is not defined");
        
        if (!booleans.get(name).contains(value))
            booleans.get(name).add(value);
    }
    
    public void putInteger(String name, Integer value) {
        if (!integers.containsKey(name))
            System.err.println(name + "is not defined");
        else {
            if (!integers.get(name).contains(value))
                integers.get(name).add(value);
        }
    }
    
    public void defineBoolean(String name, Boolean value) {
        if (booleans.containsKey(name))
            System.err.println(name + "is already defined");
        
        booleans.put(name, new ArrayList<Boolean>());
        if (value != null) 
            booleans.get(name).add(value);
    }
    
    public void defineInteger(String name, Integer value) {
        if (integers.containsKey(name))
            System.err.println(name + "is already defined");
        
        integers.put(name, new ArrayList<Integer>());
        if (value != null) 
            integers.get(name).add(value);
    }
    
}
