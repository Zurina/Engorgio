package tcpc;

import java.io.*; 
import static java.lang.Integer.parseInt;
import java.net.*; 
import java.util.Scanner; 
  
// Client class 
public class TCPC  
{ 
    public static void main(String[] args) throws IOException { 
        try { 
            Scanner scn = new Scanner(System.in); 
            Socket socket = null;
            if (args.length == 2) {
                System.out.println("Arguments received!!");
                socket = new Socket(args[0], parseInt(args[1]));
            }
            else {
                System.out.println("Give me the damn arguments!!");
                System.exit(0);
            }
              
            DataInputStream in = new DataInputStream(socket.getInputStream()); 
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
      
            while (true) { 
                System.out.println(in.readUTF()); 
                String tosend = scn.nextLine(); 
                out.writeUTF(tosend); 
                  
                if(tosend.equals("Stop")) { 
                    System.out.println("Closing this connection : " + socket); 
                    socket.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                } 
                  
                String received = in.readUTF(); 
                System.out.println(received); 
            } 
              
            // closing resources 
            scn.close(); 
            in.close(); 
            out.close(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    } 
} 