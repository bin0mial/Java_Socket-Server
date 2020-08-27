/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5001);
            ArrayList<String> store = new ArrayList<>();
            while(true){
            Socket socket = server.accept();
            Socket repServer = new Socket("localhost", 5002);
            PrintWriter pw = new PrintWriter(repServer.getOutputStream());
            
            Scanner scanClient = new Scanner(socket.getInputStream());
            String text;
            while(scanClient.hasNextLine()){
                text = scanClient.nextLine();
                store.add(text);
                pw.println(text);
                pw.flush();
                System.out.println("Client: "+text+"(Just for display)");
            }
            pw.close();
            socket.close();
            System.out.println("ArrayList contains:");
            store.forEach(e -> System.out.println(e));
            System.out.println("--------------End of ArrayList--------------");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
