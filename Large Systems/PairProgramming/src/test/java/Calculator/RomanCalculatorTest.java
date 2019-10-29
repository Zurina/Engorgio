/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calculator;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orchi
 */
public class RomanCalculatorTest {

    public RomanCalculatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCalc1GivesI() {
        String roman = RomanCalculator.convert(1);
        assert(roman).equals("I");
    }

    @Test
    public void testCalc2GivesII() {
        String roman = RomanCalculator.convert(2);
        assert(roman).equals("II");
    }

    @Test
    public void testCalc3GivesIII() {
        String roman = RomanCalculator.convert(3);
        assert(roman).equals("III");
    }

    @Test
    public void testCalc4GivesIV() {
        String roman = RomanCalculator.convert(4);
        assert (roman).equals("IV");
    }

    @Test
    public void testCalc5GivesV() {
        String roman = RomanCalculator.convert(5);
        assert (roman).equals("V");
    }

    @Test
    public void testCalc6GivesVI() {
        String roman = RomanCalculator.convert(6);
        assert (roman).equals("VI");
    }

}
