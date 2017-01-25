/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcon;

import java.util.Scanner;


/**
 *
 * @author sean
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner ui = new Scanner(System.in);
        System.out.println("Please type a number");
        String data = ui.next();
        System.out.println("type and system");
        int type = ui.nextInt();
        API ap = new API(data, type);
        ap.startConversion();
        
        
    }
    
}
