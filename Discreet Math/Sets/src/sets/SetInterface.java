/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.Set;

/**
 *
 * @author Orchi
 */
public interface SetInterface<T> {
    
    public boolean member(Set<T> set, T element);
    public Set<T> union(Set<T> set);
    public Set<T> intersection(Set<T> set);
    public Set<T> difference(Set<T> set);
    public Set<T> complement();
    public Integer compareTo(SetInterface<T> set);
    
}
