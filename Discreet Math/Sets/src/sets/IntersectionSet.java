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
public class IntersectionSet<T> implements SetInterface<T> {
    
    Set<T> first;

    public IntersectionSet(Set<T> first) {
        this.first = first;
    }

    @Override
    public boolean member(Set<T> second, T element) {
        return first.contains(element) && second.contains(element) ? true : false;
    }

    @Override
    public Set<T> union(Set<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<T> intersection(Set<T> set) {
        Set<T> all = new HashSet();
        all.addAll(first);
        all.addAll(set);
        return all;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
