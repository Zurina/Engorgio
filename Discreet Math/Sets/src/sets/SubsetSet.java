/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Orchi
 */
public class SubsetSet<T> implements SetInterface<T>{
    
    Set<T> first;

    public SubsetSet(Set<T> first) {
        this.first = first;
    }
    
    @Override
    public boolean member(Set<T> set, T element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<T> union(Set<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<T> intersection(Set<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<T> difference(Set<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<T> complement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer compareTo(SetInterface<T> set) {
        // Set and method for checking for subsets
        SubsetSet<T> second = (SubsetSet<T>) set;
       
        int lengthDiff = first.size() - second.first.size();
        
        if (lengthDiff == 0) 
            return first.containsAll(second.first) ? 0 : -2;
        
        else if (lengthDiff >= 1) 
            return first.containsAll(second.first) ? 1 : -2;
        
        else if (lengthDiff <= -1) 
            return second.first.containsAll(first) ? -1 : -2;
        
        else return 2;
    }

    
}
