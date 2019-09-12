/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

/**
 *
 * @author Orchi
 */
public class Student implements Serializable{
    
    private final String firstname;
    private final String email;
    
    public Student(String firstname, String email) {
        this.firstname = firstname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Firstname: " + this.firstname + ", Email: " + this.email;
    }
}
