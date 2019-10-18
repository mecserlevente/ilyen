/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MECLEVAA
 */
public class JavaApplication6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<stadions>lista=new ArrayList<stadions>();
       beolvas(lista); 
        
    }
    
     public static void beolvas(ArrayList<stadions>lista){
     try{
        File adat=new File("szoveg.txt");
        Scanner fileinput=new Scanner(adat);
        while(fileinput.hasNextLine()){
        String data=fileinput.nextLine();
        String[]tomb=data.split(";");
        lista.add(new stadions(tomb[0],tomb[1],tomb[2],Integer.parseInt(tomb[3])));

        }fileinput.close();
              
                }catch(FileNotFoundException e){System.out.println(e);}
    
    }
     
     }

