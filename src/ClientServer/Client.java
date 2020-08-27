/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 5001);
            PrintWriter pw = new PrintWriter(client.getOutputStream());
            String txt ;
            Scanner scan = new Scanner(System.in);
            txt = scan.nextLine();
            //Stops when sends Empty String
            while(!txt.equals("")){
                pw.println(txt);
                pw.flush();
                txt = scan.nextLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
