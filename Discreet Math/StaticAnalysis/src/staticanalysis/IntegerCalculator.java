/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticanalysis;

/**
 *
 * @author stanislavnovitski
 */
public class IntegerCalculator {

    static int calculateInteger(int firstOprand, String operator, int secondOprand) {
        int result = 0;
        switch (operator) {
            case "+": {
                result = firstOprand + secondOprand;
            }
            break;
            case "-": {
                result = firstOprand - secondOprand;
            }
            break;
            case "/": {
                result = firstOprand / secondOprand;
            }
            break;
            case "*": {
                result = firstOprand * secondOprand;
            }
            break;
            default:
                result = 0;

        }
        return result;
    }
}
