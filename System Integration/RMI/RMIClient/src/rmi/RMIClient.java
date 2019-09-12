/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Orchi
 */
import java.rmi.Naming;
import java.util.List;

public class RMIClient {

    private RMIClient() {}

    public static void main(String[] args) {
        try {
            String key = "students";
            Interaction stub = (Interaction) Naming.lookup(key);
            List<Student> response = (List<Student>) stub.readData();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
