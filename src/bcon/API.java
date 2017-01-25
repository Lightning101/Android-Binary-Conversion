/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcon;

/**
 *
 * @author sean
 * this class will act as an interface between the front end and back end
 */
public class API {
    
    
    private class Splitter {
        private String data;
        private String intData;
        private String decData;
        private int type;
        private String[] parts;
        private boolean hasDecimal;
    
    
         public Splitter(String data, int type)
        {
            this.data = data;
            this.type = type;
      
        }
    
        public void setData(String data, int type)
        {
            this.data = data;
            this.type = type;
        }
    
        public void split()
        {
            
            //System.out.println(data);
            int pos = data.indexOf(46);
            if(pos!= -1){
           
            intData = data.substring(0, pos);
            decData = data.substring(pos+1,data.length());
            //System.out.println(intData);
            //System.out.println(decData);
            hasDecimal = true;
            }else
            {
                hasDecimal = false;
                intData = data;
               // System.out.println(intData);
            }
        
            convert();
           
        }
        
        public void convert()
        {
             switch(type)
                       {
                    case 2:
                
                        break;
            
                    case 8:
                
                        break;
            
                    case 10:
                       if(hasDecimal){
                        
                           Decimal dec = new Decimal(intData, decData);
                       }
                       else
                       {
                        Decimal dec = new Decimal(intData);
                        
                       }
                       
                        Decimal dec = new Decimal(intData);
                        DecToAny dCon = new DecToAny(dec);
                        dCon.convert();
                        dec.printAwns();
                        
                        
                       break;
            
                    case 16:
                
                       break;
                     }
        }   
        
    }
    
    private String data; //data will be held as a string for userbility
    private int type; // type will also be held as int for ease of use binary 2 . octal 8, decimal 10 and hexa 16
    Splitter sp;
    
    
    public API(String data,int type)
    {
        this.data = data;
        this.type = type;
    }
    
    //made method so same object can be reused
    public void setData(String data,int type)
    {
        this.data = data;
        this.type = type;
    }
    
    public void startConversion()
    {
        sp = new Splitter(data, type);
        sp.split();
    }
    
}
