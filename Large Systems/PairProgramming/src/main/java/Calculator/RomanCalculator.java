/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

/**
 *
 * @author Orchi
 */
public class RomanCalculator {

    static String convert(int i) {
        String result = "";
        switch(i) {
            case 1:
                result = "I";
                break;
            case 2: 
                result = "II";
                break;
            case 3: 
                result = "III";
                break;
            case 4: 
                result = "IV";
                break;
            case 5: 
                result = "V";
                break;
            case 6: 
                result = "VI";
                break;
            default: {
                result = "Nulla";
            }
        }
        return result;
    }
}
