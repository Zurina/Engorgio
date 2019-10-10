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
        
        // RANGE SET
        RangeSet<Integer> rs = new RangeSet<Integer>(4, 8);
        RangeSet<Integer> rs2 = new RangeSet<Integer>(5, 8);
        System.out.println(rs.compareTo(rs2));
        
        // UNION SET
        SetInterface<Integer> us = new UnionSet(firstSet);
        System.out.println(us.union(secondSet)); // the union set of 'firstSet' & 'secondSet'
        System.out.println(us.member(secondSet, 7)); // Not part of the union set
        System.out.println(us.member(secondSet, 13)); // Part of the union set
        
        // INTERSECTION SET
        SetInterface<Integer> is = new IntersectionSet<>(firstSet);
        System.out.println(is.member(secondSet, 4)); // Part of both sets
        System.out.println(is.intersection(secondSet)); // The intersection set
        
        // DIFFERENCE SET
        SetInterface<Integer> ds = new DifferenceSet<>(firstSet);
        System.out.println(ds.member(secondSet, 10)); // Part of the set firstSet - secondSet ( A - B ).
        System.out.println(ds.difference(secondSet)); // The difference set
        
        // COMPLEMENT SET
        SetInterface<Integer> cs = new ComplementSet<>(firstSet);
        System.out.println(cs.member(null, 54)); // Part of the complement set of 'firstSet'
        System.out.println(cs.complement());
        
        

    }

}
