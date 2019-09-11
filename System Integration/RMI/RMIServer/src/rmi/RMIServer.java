/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Orchi
 */
public class RMIServer implements Interaction {
    
    public static Registry registry;
        
    public RMIServer() {}

    @Override
    public String readData() {
        
        List<String> students = new ArrayList<>();
        try {
            String myUrl = "jdbc:mysql://localhost:3306/rmi";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            java.sql.Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String email = rs.getString("email");
                students.add("Name: " + firstname + ", email: " + email);
            }
            File file = new File("C:\\Users\\Orchi\\Desktop\\Engorgio\\System Integration\\RMI\\students.txt"); 
            BufferedReader br = new BufferedReader(new FileReader(file)); 
            String st; 
            while ((st = br.readLine()) != null) 
                students.add(st);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
            for(String student : students) {
                System.out.println(student);
        }
        return students.toString(); 
    }
        
    public static void main(String args[]) {
        
        try {
            
            registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry created ");
            
            Interaction RMIServer = new RMIServer();
            String key = "students";
            
            Interaction stub = (Interaction) UnicastRemoteObject.exportObject(RMIServer, 0);
            Naming.rebind(key, stub);

            System.err.println("RMI server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
