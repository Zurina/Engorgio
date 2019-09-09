package tcps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


class SocketThread extends Thread { 
    final Socket socket; 
  
    public SocketThread(Socket socket) { 
        this.socket = socket; 
    } 
  
    @Override
    public void run() { 
        String request; 
        String response; 
        DataInputStream in = null;
        DataOutputStream out = null;
        while (true) { 
            try { 
                in = new DataInputStream(socket.getInputStream()); 
                out = new DataOutputStream(socket.getOutputStream()); 
  
                // Ask user what he wants 
                out.writeUTF("Write whatever you want and get the reversed sent back\n"+ 
                            "Type Stop to terminate connection."); 
                  
                // receive the answer from client 
                request = in.readUTF(); 
                  
                if(request.equals("Stop")) {  
                    System.out.println("Client " + this.socket + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.socket.close(); 
                    System.out.println("Connection closed"); 
                    break; 
                }
                
                response = new StringBuilder(request).reverse().toString();
                out.writeUTF(response);
                  
            } catch (IOException e) { 
                e.printStackTrace();
                try {
                    in.close();
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(SocketThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        } 
    } 
} 