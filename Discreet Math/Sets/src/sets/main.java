/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Orchi
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Sets I will use through the sets
        Integer[] arrayOne = {2, 6, 1, 4, 10}; 
        Integer[] arrayTwo = {5, 6, 3, 4, 11, 13};
        Set<Integer> firstSet = new HashSet(Arrays.asList(arrayOne));
        Set<Integer> secondSet = new HashSet(Arrays.asList(arrayTwo));
        System.out.print("first set consists of following elements: ");
        firstSet.forEach(element -> System.out.print(element + ", "));
        System.out.println("");
        System.out.print("second set consists of following elements: ");
        secondSet.forEach(element -> System.out.print(element + ", "));
        System.out.println("");
        
        System.out.println("\nRANGE SET");
        RangeSet<Integer> rs = new RangeSet<Integer>(4, 8);
        RangeSet<Integer> rs2 = new RangeSet<Integer>(5, 8);
        System.out.println("rs compared to rs2: " + rs.compareTo(rs2));
        System.out.println("whether the number 7 is a member of the rs set: " + rs.member(null, 7));
        
        System.out.println("\nUNION SET");
        SetInterface<Integer> us = new UnionSet(firstSet);
        System.out.println("the union set of first set and second set: " + us.union(secondSet)); // the union set of 'firstSet' & 'secondSet'
        System.out.println("whether the number 7 is member of the union set: " + us.member(secondSet, 7)); // Not part of the union set
        System.out.println("whether the number 13 is member of the union set: " + us.member(secondSet, 13)); // Part of the union set
        
        System.out.println("\nINTERSECTION SET");
        SetInterface<Integer> is = new IntersectionSet<>(firstSet);
        System.out.println("the intersection set of first set and second set: " + is.intersection(secondSet)); // The intersection set
        System.out.println("whether the number 4 is member of the intersection set: " + is.member(secondSet, 4)); // Part of both sets
        System.out.println("whether the number 13 is member of the intersection set: " + is.member(secondSet, 13)); // Not Part of both sets
        
        System.out.println("\nDIFFERENCE SET");
        SetInterface<Integer> ds = new DifferenceSet<>(firstSet);
        System.out.println("the difference set ( A - B ) first set - second set: " + ds.difference(secondSet)); // The difference set
        System.out.println("whether the number 10 is a part of the difference of first set and second set: " + ds.member(secondSet, 10)); // Part of the set firstSet - secondSet ( A - B ).
        
        System.out.println("\nCOMPLEMENT SET");
        SetInterface<Integer> cs = new ComplementSet<>(firstSet);
        System.out.println("whether the number 54 is part of the difference set of firstset: " + cs.member(null, 54)); 
        System.out.println("the complement set of first set: " + cs.complement());
        
        System.out.println("\nSUBSET SET");
        SetInterface<Integer> ss = new SubsetSet<>(firstSet);
        SetInterface<Integer> ss2 = new SubsetSet<>(secondSet);
        System.out.println("first set compared to second set: " + ss.compareTo(ss2)); // Part of the complement set of 'firstSet'
        
        

    }

}
