/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package setsexercise;

import java.util.Arrays;

/**
 *
 * @author Orchi
 */
public class SetsExercise {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {2, 1};
        System.out.println(compareSet(a, b));
    }
    
    public static int compareSet(int[] a, int[] b) {
        if (Arrays.equals(a, b))
            return 0;
        
        if(a.length < b.length) {
            for(int i = 0; i < a.length; i++) {
                boolean found = false;
                for(int j = 0; j < b.length; j++) {
                    if(a[i] == b[j])
                        found = true;
                }
                if (!found) return -2;
            }
            return -1;
        }
        
        if(b.length < a.length) {
            for(int i = 0; i < b.length; i++) {
                boolean found = false;
                for(int j = 0; j < a.length; j++) {
                    if(b[i] == a[j])
                        found = true;
                }
                if (!found) return -2;
            }
            return 1;
        }
        
        return -2;
    }
    
}
