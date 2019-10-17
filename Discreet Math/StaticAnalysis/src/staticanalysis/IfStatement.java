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
            String[] elements = nextVSSLLine.split(" ");
            
            String stringRegex = "([A-Za-z])*";
            String intRegex = "([0-9])*";
            
            e1 = interpretElement(elements[0], state);
            e2 = interpretElement(elements[2], state);
            
            switch (elements[1]) {
                case "<": {
                    
                }
                break;
            }
            
        }
    }
    
    public static Object interpretElement(String element, State state) throws Exception{
        String stringRegex = "([A-Za-z])*";
        String intRegex = "([0-9])*";
        Object e;

        if (element.matches(stringRegex)) {
            if (state.isVariableBoolean(element)) {
                e = (Boolean) state.getValueOfBoolVariable(element);
                if (e == null) throw new NullPointerException();
            }
            else if (state.isVariableInteger(element)) {
                e = (Integer) state.getValueOfIntVariable(element);
                if (e == null) throw new NullPointerException();
            }
            else 
                throw new Exception(element + " is undefined");
        }

        else if (element.matches(intRegex)) 
            e = Integer.parseInt(element);

        else
            throw new Exception(element + " is neither a integer or variable");
        
        return e;
    }
 }
