/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timer;

/**
 *
 * @author Orchi
 */
public class Timer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Mark0();
    }
    
    private long start, spent = 0;
    
    public Timer() { play(); }
    
    public double check() { return (System.nanoTime()-start+spent)/1e9; }
    
    public void pause() { spent += System.nanoTime()-start; }
    
    public void play() { start = System.nanoTime(); }

    public static void Mark0() { // USELESS
        Timer t = new Timer();
        double dummy = multiply(10);
        double time = t.check() * 1e9;
        System.out.printf("%6.1f ns%n", time);
    }
    
    private static double multiply(int i) {
        double x = 1.1 * (double)(i & 0xFF);
        return x * x * x * x * x * x * x * x * x * x
        * x * x * x * x * x * x * x * x * x * x;
    }
    
}
