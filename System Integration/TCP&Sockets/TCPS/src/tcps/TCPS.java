package tcps;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dora Di
 * 
 * 1. Create a server socket and bind it to a specific port number
 * 2. Listen for a connection from the client and accept it. This results in a client socket, created on the server, for the connection.
 * 3. Read data from the client via an InputStream obtained from the client socket
 * 4. Send data to the client via the client socket’s OutputStream.
 * 5. Close the connection with the client.
 * 
 * The steps 3 and 4 can be repeated many times depending on the protocol agreed between the server and the client.
 */

public class TCPS 
{
    
    public static Integer PORT = 6666;

    public static void main(String[] args) throws IOException {      
        ServerSocket mainSocket = new ServerSocket(PORT); 
        
        String serverIP = InetAddress.getLocalHost().getHostAddress();
        System.out.println("Server ip: " + serverIP);
        int count = 0;
        // Listening for client requests 
        while (true) { 
            // New Socket connection for each client
            Socket socket = null; 
            try { 
                // Establish connection to socket 
                socket = mainSocket.accept(); 
                
                System.out.println(count++);
                  
                System.out.println("A new client is connected : " + socket);
                
                System.out.println("Assigning new thread for this client"); 
                Thread t = new SocketThread(socket); 
                t.start(); 
            } 
            catch (Exception e){ 
                socket.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
}
    