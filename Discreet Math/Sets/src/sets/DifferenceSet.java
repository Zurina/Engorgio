/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Orchi
 */
public class DifferenceSet<T> implements SetInterface<T> {
    
    Set<T> first;

    public DifferenceSet(Set<T> first) {
        this.first = first;
    }

    @Override
    public boolean member(Set<T> second, T element) {
        return this.first.contains(element) && !second.contains(element) ? true : false;
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
        Set<T> difference = new HashSet();
        for (T ele : first) 
            if (!set.contains(ele)) difference.add(ele);
        return difference;
    }

    @Override
    public Set<T> complement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer compareTo(SetInterface<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
