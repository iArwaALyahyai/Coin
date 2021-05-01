/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10_ex2_129130;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arwa
 */
public class Coin
{
   private double value;
   private String name;

   /**
      Constructs a coin.
      @param aValue the monetary value of the coin
      @param aName the name of the coin
   */
      public Coin() 
   { 
      value = 0; 
      name = "";
   }
   public Coin(double aValue, String aName) 
   { 
      value = aValue; 
      name = aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }
   
   public void read(Scanner in) throws FileNotFoundException {
       
       String line = in.nextLine();
       String[] info = line.split(" ");
       name = info[0];
       String valueS = info[1];
       value = Double.parseDouble(valueS);
       if(info[0].startsWith("r")||info[0].startsWith("b")){throw new InsufficientCoinException();}
       if(info.length!=2){throw new InsufficientCoinException();}
       
   }
}