/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcon;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.Stack;

/**
 *
 * @author sean
 */
public class DecToAny {
    
   private Decimal dec;
   
   Stack s;
   
   
   
   
   
   
   DecToAny(Decimal decimal)
   {
       this.dec = decimal;
       s = new Stack();
   }
    
    
    
    
    public void convert()
    {
        
        intCon(2);
        intCon(8);
        intCon(16);
        //  System.out.println("Got here "+dec.hasDec());
        if(dec.hasDec()){
        decCon(2);
        decCon(8);
        decCon(16);
        }
        
    }
    
    
    public void intCon(int System)
    {
        s.removeAllElements();
        int temp = getDataInt();
        
        while(temp != 0)
        {
            s.push(temp%System);
            //java.lang.System.out.println(temp%System);
            temp = temp /System;
            
        }
        
        StringBuilder build = new StringBuilder();
        
         switch(System)
       {
            case 2:
                while(!s.empty())
                {
                    
                    build.append((int)s.pop());
                    
                }
                dec.setAnsInt(System,build.toString());
                break;
            
            case 8: 
                while(!s.empty())
                {
                    build.append((int)s.pop());
                    
                }
                dec.setAnsInt(System,build.toString());
                break;
               
            
            case 16:
                while(!s.empty())
                {
                    build.append((int)s.pop());
                    
                }
                dec.setAnsInt(System,build.toString());
                break;
                
       }
        
    }
    public void decCon(int System)
    {
        s.removeAllElements();
       double temp = getDataDec();
       
       while(temp != 0)
       {
           temp = temp *System;
           s.add(temp%1);
           temp = temp -((int)temp/1);
           
       }
       
       StringBuilder build = new StringBuilder();
        
         switch(System)
       {
            case 2:
                while(!s.empty())
                {
                    build.append((int)s.pop());
                    
                }
                build.reverse();
                dec.setAnsDec(System,build.toString());
                break;
            
            case 8: 
                while(!s.empty())
                {
                    build.append((int)s.pop());
                    
                }
                build.reverse();
                dec.setAnsDec(System,build.toString());
                break;
               
            
            case 16:
                while(!s.empty())
                {
                    build.append((int)s.pop());
                    
                }
                build.reverse();
                dec.setAnsDec(System,build.toString());
                break;
                
       }
       
       
        
    }
    
    private int getDataInt()
    {
       return Integer.parseInt(dec.getIntData());
    }
    
    private double getDataDec()
    {
        return Double.parseDouble("0."+dec.getDecData());
    }
    
  
   
}
