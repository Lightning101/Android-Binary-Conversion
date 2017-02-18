/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apphunters.bconvo;

/**
 *
 * @author sean
 */
public class AnyToDec {
    private String intData;
    private String DecData;
    private int NumSys;
    private boolean hasDec;
    private int intFinal;
    private int decFinal;
    
    
    
    
    
    public AnyToDec(String intData, int NumSys)
    {
        this.intData = intData;
       
        this.NumSys = NumSys;
        hasDec = false;
        convert();
    }
    
    public AnyToDec(String intData, String decData, int NumSys)
    {
        this.intData = intData;
        this.NumSys = NumSys;
        this.DecData = decData;
        hasDec = true;
        convert();
    }
    
    public void convert()
    {
       
        intFinal = Integer.parseInt(intData, NumSys);
        
        if(hasDec)
        {

                decFinal = conDec(DecData);

        }
    }
    
    
    public int conDec(String decD)
    {
        double value =0;
        int power = 1;
        String temp = decD;
        for(int i =0; i<temp.length();i++ )
        {
            int temp2;
            String hold  = temp.substring(i,i+1);

            if(hold.indexOf('A') != -1)
            {
                temp2 = 10;
            }else if(hold.indexOf('B') != -1)
            {
                temp2 = 11;
            }else if(hold.indexOf('C') != -1)
            {
                temp2 = 12;
            }else if(hold.indexOf('D') != -1)
            {
                temp2 = 13;
            }else if(hold.indexOf('E') != -1)
            {
                temp2 = 14;
            }else if(hold.indexOf('F') != -1)
            {
                temp2 = 15;
            }else
            {
                temp2 = Integer.parseInt(hold);
            }

            value = value +powerer(temp2,power);
            
        }
        temp = String.valueOf(value);
        temp = temp.substring(2,temp.length());
        return Integer.parseInt(temp);
       
    }
    
    public double powerer(int data , int times)
    {
        double temp = Math.pow(NumSys , times);
        
        temp = data/temp;
        return temp;
    }
    
    public Decimal getDec()
    {
        if(hasDec)
        {
            
            return (new Decimal(String.valueOf(intFinal), String.valueOf(decFinal)));
        }else
        {
            return (new Decimal(String.valueOf(intFinal)));
        }
        
        
    }
    
}
