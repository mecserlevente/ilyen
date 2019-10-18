/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MECLEVAA
 */
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         ArrayList<Euk>lista=new ArrayList<Euk>();
          beolvas(lista);      
         
          
  } 
    
public static void beolvas(ArrayList<Euk>lista){
try{
        File adat=new File("szoveg.txt");
        Scanner fileinput=new Scanner(adat);
        while(fileinput.hasNextLine()){
        String data=fileinput.nextLine();
        String[]tomb=data.split(";");
        String[]ido=tomb[1].split(".");
        LocalDate temp=LocalDate.of(Integer.parseInt(tomb[1]),Integer.parseInt(tomb[2]),Integer.parseInt(tomb[3]));
        lista.add(new Euk((temp,tomb[0]));
        }fileinput.close();
        }catch(FileNotFoundException e){System.out.println(e);} 
      
}
    
     
}
