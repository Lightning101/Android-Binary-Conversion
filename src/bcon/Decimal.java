/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcon;

/**
 *
 * @author sean
 */
public class Decimal {
    
    private String intData;
    private String decData;
    private String ansB; // answer in Binary
    private String ansO; // answer in Octal
    private String ansH; // anser in Hexa
    private boolean hasDec;
    
    
    
    
    
    public Decimal(String intData)
    {
        this.intData = intData;
        this.hasDec = false;
      
    }
    
    
    public Decimal(String intData , String decData)
    {
        this.intData = intData;
        this.decData = decData;
        this.hasDec = true;
        System.out.println(hasDec);
        
        
    }
    
   public String getIntData()
   {
       return intData;
   }
    
   public String getDecData()
   {
       return decData;
   }
   
   
   public void setAnsInt(int System, String Answer)
   {
       
       switch(System)
       {
            case 2:
                ansB = Answer;
                break;
            
            case 8:
                ansO = Answer;
                break;
            
            case 16:
                ansH = Answer;
                break;
       }
       
      
      
   }
   
   public void setAnsDec(int System, String Answer)
   {
       
       StringBuilder  build = new StringBuilder();
       switch(System)
       {
            case 2:
                build.append(ansB);
                build.append("."+Answer);
                ansB=build.toString();
                break;
            
            case 8:
                build.append(ansB);
                build.append("."+Answer);
                ansB=build.toString();
                break;
            
            case 16:
                build.append(ansB);
                build.append("."+Answer);
                ansB=build.toString();
                break;
       }
       
   }
   
   public void printAwns()
   {
       java.lang.System.out.println(ansB);
      java.lang.System.out.println(ansO);
      java.lang.System.out.println(ansH);
      java.lang.System.out.println(hasDec);
   }
   
   public boolean hasDec()
   {
       System.out.println(hasDec);
       return this.hasDec;
   }
   
   
}
