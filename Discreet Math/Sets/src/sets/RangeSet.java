/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Orchi
 * @param <T>
 */
public class RangeSet<T extends Number> implements SetInterface<T> {
    
    Number min;
    Number max;

    public RangeSet(T min, T max) {
        this.min = min;
        this.max = max;
    }
    
    @Override
    public boolean member(Set<T> second, T e) {
        return min.doubleValue() >= e.doubleValue() && max.doubleValue() <= e.doubleValue();
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
    public Integer compareTo(SetInterface<T> newSet) {
        RangeSet<T> set = (RangeSet<T>) newSet;
        Double range1 = Math.abs(min.doubleValue() - max.doubleValue());
        Double range2 = Math.abs(set.min.doubleValue() - set.max.doubleValue());
        if (Objects.equals(range1, range2)) return 0;
        else if (range1 > range2) return 1;
        else return -1;
    }

    @Override
    public boolean equals(Object obj) {
        RangeSet<T> set = (RangeSet<T>) obj;
        return min.doubleValue() == set.min.doubleValue() && max.doubleValue() == set.max.doubleValue();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.min);
        hash = 89 * hash + Objects.hashCode(this.max);
        return hash;
    }
}
