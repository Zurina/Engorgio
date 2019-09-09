/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiserver;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Orchi
 */
public class RMIServer implements Interaction {
        
    public RMIServer() {}

    @Override
    public String readData() {
        return "Hello, world!";
    }
        
    public static void main(String args[]) {
        
        try {
            Interaction obj = new RMIServer();
            Interaction stub = (Interaction) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.bind("readData", stub);

            System.err.println("RMI server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
