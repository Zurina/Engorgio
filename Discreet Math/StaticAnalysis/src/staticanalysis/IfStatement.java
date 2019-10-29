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

    public static boolean analyze(String nextVSSLLine, State state) throws Exception {
        Boolean result = false;
        String regex = "(IF) ([A-Za-z0-9])* (<=|>=|<|>|==) ([A-Za-z0-9])* (THEN) [{]";
        if (nextVSSLLine.matches(regex)) {
            Object e1;
            Object e2;

            nextVSSLLine = nextVSSLLine.substring(3);
            String[] elements = nextVSSLLine.split(" ");

            e1 = interpretElement(elements[0], state);
            e2 = interpretElement(elements[2], state);

            result = booleanCalculator(e1, e2, elements[1]);
        }
        return result;
    }

    public static Boolean booleanCalculator(Object e1, Object e2, String operator) throws Exception {
        String e1ClassName = e1.getClass().getSimpleName();
        String e2ClassName = e2.getClass().getSimpleName();
        Boolean result = false;
        if (e1ClassName.equals("Integer") && e2ClassName.equals("Integer")) {
            Integer element1 = (Integer) e1;
            Integer element2 = (Integer) e2;
            switch (operator) {
                case "<": {
                    result = element1 < element2;
                }
                break;
                case ">": {
                    result = element1 > element2;
                }
                break;
                case "<=": {
                    result = element1 <= element2;
                }
                break;
                case ">=": {
                    result = element1 >= element2;
                }
                break;
                case "==": {
                    result = element1 == element2;
                }
                break;
                default: {
                    System.err.println("You somehow got passed my regex for operators..");
                }
            }
        } else if (e1ClassName.equals("Boolean") && e2ClassName.equals("Boolean")) {
            Boolean element1 = (Boolean) e1;
            Boolean element2 = (Boolean) e2;
            if (operator.equals("==")) {
                result = element1 == element2;
            } else {
                throw new Exception(operator + " is not fit for comapring booleans");
            }
        } else {
            throw new Exception("Unable to compare types: " + e1ClassName + " & " + e2ClassName);
        }

        return result;
    }

    public static Object interpretElement(String element, State state) throws Exception {
        String stringRegex = "([A-Z])*";
        String intRegex = "([0-9])*";
        Object e;

        if (element.matches(stringRegex)) {
            if (state.isVariableBoolean(element)) {
                e = (Boolean) state.getValueOfBoolVariable(element);
                if (e == null) {
                    throw new NullPointerException();
                }
            } else if (state.isVariableInteger(element)) {
                e = (Integer) state.getValueOfIntVariable(element);
                if (e == null) {
                    throw new NullPointerException();
                }
            } else if ("TRUE".equals(element)) {
                e = (Boolean) true;
            } else if ("FALSE".equals(element)) {
                e = (Boolean) false;
            } else {
                throw new Exception(element + " is undefined");

            }
        } else if (element.matches(intRegex)) {
            e = Integer.parseInt(element);
        } else {
            throw new Exception(element + " is neither a integer or variable");
        }

        return e;
    }

    public static void main(String[] args) throws Exception {
        Object e1;
        Object e2;

        e1 = interpretElement("true", new State());
        e2 = interpretElement("true", new State());

        System.out.println(booleanCalculator(e1, e2, "=="));
    }

}
