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
public class UnionSet<T> implements SetInterface<T> {
    
    Set<T> first;

    public UnionSet(Set<T> first) {
        this.first = first;
    }
    
    @Override
    public boolean member(Set<T> second, T element) {
        return first.contains(element) || second.contains(element) ? true : false;
    }

    @Override
    public Set<T> union(Set<T> set) {
        Set<T> unionSet = new HashSet();
        unionSet.addAll(first);
        unionSet.addAll(set);
        return unionSet;
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
        // Why and how to compare two union sets??
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
