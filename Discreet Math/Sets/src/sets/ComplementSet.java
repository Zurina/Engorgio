/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Orchi
 */
public class ComplementSet<T> implements SetInterface<T>{
    
    Set<T> complementSet;

    public ComplementSet(Set<T> complementSet) {
        this.complementSet = complementSet;
    }
    
    @Override
    public boolean member(Set<T> set, T element) {
        return !complementSet.contains(element);
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
        System.out.println("The following set returned contains everything in the universe but: \n");
        Iterator it = complementSet.iterator();
        while(it.hasNext()) System.out.println(it.next());
        return new HashSet<T>(); // ∞
    }

    @Override
    public Integer compareTo(SetInterface<T> set) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
