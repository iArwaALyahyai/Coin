/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10_ex2_129130;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Arwa
 */
public class Lab10_ex2_129130 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Coin> c = new ArrayList<Coin>();
        Scanner in = new Scanner(System.in);
        boolean found = false;
        while(!found){
            try{
                System.out.println("Enter file name: ");
                String inputF = in.nextLine();
                File inp = new File(inputF);
                Scanner inFile = new Scanner(inp);
                

                Lab10_ex2_129130.readFile(inputF,c);
                System.out.println("Total in Riyal: "+Lab10_ex2_129130.total(c));
                found = true;
            }
            catch(FileNotFoundException E ){
                 System.out.println("File not found");
            }
            
            
        }
    }
    
    public static ArrayList<Coin> readFile(String filename,ArrayList<Coin> C) throws FileNotFoundException{
        File in = new File(filename);
        Scanner inFile = new Scanner(in);
        int i = 0;
        while(inFile.hasNextLine()){
           try{
            Coin cc = new Coin();
            cc.read(inFile);
            C.add(cc);
            System.out.print(C.get(i).getName()+" "+C.get(i).getValue());
            System.out.println();
            i++;
            }
            catch(InsufficientCoinException E)
            {
                System.out.println("Bad data");
            }
        }
        return C;
    }
    
    public static double total(ArrayList<Coin> C)
    {
        int total = 0;
        for(int i = 0; i<C.size();i++)
        {
            if(C.get(i).getName().equals("Baisa"))
            {
                double r = C.get(i).getValue() / 1000;
                total += r;
            }
            else{
            total += C.get(i).getValue();
            }
        }
        return total;
    }
    
    }
   
