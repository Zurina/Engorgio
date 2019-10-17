/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticanalysis;

/**
 *
 * @author Orchi
 */
public class IfStatement {
    
    public static void analyze(String nextVSSLLine, State state) throws Exception {
        String regex = "(IF) ([A-Za-z0-9])* (<=|>=|<|>|==) ([A-Za-z0-9])* (THEN) {";
        if (nextVSSLLine.matches(regex)) {
            
            Object e1;
            Object e2;
            
            nextVSSLLine = nextVSSLLine.substring(3); 
            String stringRegex = "([A-Za-z])*";
            String intRegex = "([0-9])*";
            
            String[] elements = nextVSSLLine.split(" ");
            
            if (elements[0].matches(stringRegex)) {
                if (state.isVariableBoolean(elements[0])) {
                }
                else if (state.isVariableInteger(elements[0])) {
                    
                }
                else 
                    throw new Exception(elements[0] + " is undefined");
            }
                
            else if (elements[0].matches(intRegex)) {
            
            }
            
            else
                throw new Exception(elements[0] + " is neither a integer or variable");
        }
    }
 }
