/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Radio {

public static boolean szame(String szo){
boolean valasz=true;
for (int i = 1; i < Integer.parseInt(szo); i++) {
if (szo.charAt(i)<'0' || szo.charAt(i)>'9') {
 valasz=false;
 
        }
    }
return valasz;
}    
   
    
    
    public static void main(String[] args) {
    int tombsorszam = -1;
    String tomb[][] = new String[1000][5];    
    String tomb2[] = new String[100];
    
    try{
        String sor;
        sor = "";
       
        BufferedReader br=new BufferedReader(new FileReader("veetel.txt")); 
        while((sor=br.readLine())!=null){
            tombsorszam++;

            //rövid sorok kezelése (napazonosító fotósazonosító)
            tomb2 = sor.split(" ");
            tomb[tombsorszam][0] = tomb2[0];
            tomb[tombsorszam][1] = tomb2[1];
        
            //hosszú sorok kezelése (felnőőfarkas/kölyökfarkas szöveg)
            sor = br.readLine();
            tomb[tombsorszam][4] = sor;
        }
    
    }catch(IOException e){
        System.out.println(e);
    }
    
    /*
    
            System.out.println("tombsorszam: "+tombsorszam);
        System.out.println("sor: "+sor);
        System.out.println("0.index: "+tomb2[0]);
        System.out.println("1.index: "+tomb2[1]);
        System.out.println("hello.");
    */
    
    /*    for (int i = 0; i <= tombsorszam; i++) {
            System.out.println("napok száma: "+tomb[i][0]);
            System.out.println("rádiós száma: "+tomb[i][1]);
            System.out.println("FFarkas száma: "+tomb[i][2]);
            System.out.println("KFarkas száma: "+tomb[i][3]);
            System.out.println(rádióüzenet: "+tomb[i][4]);
            System.out.println("");
        }
     */   
    
    System.out.println("2. feladat megoldása:");
    System.out.println("első rádióamatőr: "+tomb[0][1]+" utolsó rádióamatőr: "+tomb[tombsorszam][1]);
    System.out.println("");
        
    System.out.println("3. feladat megoldása");
    for (int i = 0; i < tombsorszam; i++) {
        if (tomb[i][4].contains("farkas")) {
            System.out.println(tomb[i][0]+" nap "+tomb[i][1]+" rádióamatőr");
        }
    }
    System.out.println("");

    System.out.println("4. feladat megoldása");
    for (int j = 1; j <= 11; j++) {
        int feljegyzesdb=0;
        for (int i = 0; i < tombsorszam; i++) {
            if (Integer.parseInt(tomb[i][0]) == j) {
                feljegyzesdb++;
            }
        }      
        System.out.println(j+". nap rádióamatőrök száma: "+feljegyzesdb);
    }
    System.out.println("");
    
    System.out.println("5. feladat megoldása");
    String dekodoltszoveg;
    for (int i = 1; i <= 11; i++) {
        dekodoltszoveg = "";
        for (int j = 0; j < tombsorszam; j++) {
            if (Integer.parseInt(tomb[j][0]) == i) {
                if (dekodoltszoveg == "") {
                    dekodoltszoveg = tomb[j][4];
                }else {
                    for (int k = 0; k < 90; k++) {
                        if (dekodoltszoveg.charAt(k)=='#') {
                            if (tomb[j][4].charAt(k)=='#') {
                            }else {
                                dekodoltszoveg = dekodoltszoveg.substring(0,k) + tomb[j][4].charAt(k) + dekodoltszoveg.substring(k+1);
                            }
                        }
                    }
                
                }
            }
        }
        System.out.println(i+".napi szöveg: "+dekodoltszoveg);
    }

    
        System.out.println("7.feladat");
        Scanner napb=new Scanner(System.in);
        String napbe=napb.nextLine();
        Scanner radiosb=new Scanner(System.in);
        String radiosbe=radiosb.nextLine();
        boolean megtalaltam=false;
        
        String tempstr;
        int ffarkasok;
        for (int i = 0; i < tombsorszam; i++) {
            if (napbe==tomb[i][0] && radiosbe==tomb[i][1]) {
                megtalaltam = true;
                ffarkasok = 0;
 
                tempstr = tempstr + tomb[i][4].charAt(0);
                if (szame(tempstr)) {
                    for (int j = 1; j < 90; j++) {
                        if (szame(tomb[i][4].charAt(j))) {
                            tempstr = tempstr + tomb[i][4].charAt(j);
                        }else{
                            break;
                        }
                    }
                    ffarkasok = Integer.parseInt(tempstr);
                    j-edik karakter micsoda???
                    
                }else{
                    System.out.println("Nincs információ.");
                }
                



                
                if (tomb[i][4].indexOf(0)>'9'||tomb[i][4].indexOf(0)<'0') {
                        System.out.println("nem állapítható meg");
            }else{
                    
                }
            
            
            
            
            }
        }
        if (megtalaltam==false) {
            System.out.println("Nincs ilyen feljegyzés!");
        }
       
    
        
    }        
}
