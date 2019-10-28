/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbradio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Cbradio {

    public static int AtszamolPercre(int ora, int perc) {
        int oraperc = ora * 60 + perc;
        return oraperc;
    }

    public static void main(String[] args) {
        ArrayList<radiok> lista = new ArrayList<radiok>();
        beolvas(lista);
        feladat3(lista);
        feladat4(lista);
        feladat5(lista);
        feladat7(lista);
        feladat8(lista);
        feladat9(lista);
    }

    public static void beolvas(ArrayList<radiok> lista) {
        try {
            File adat = new File("cb.txt");
            Scanner fileinput = new Scanner(adat);
            radiok.elsosor = fileinput.nextLine();
            while (fileinput.hasNextLine()) {
                String[] tomb = fileinput.nextLine().split(";");

                lista.add(new radiok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), tomb[3]));
            }
            fileinput.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

    }

    public static void feladat3(ArrayList<radiok> lista) {
        System.out.println("3. feladat: " + "Bejegyzések száma: " + lista.size() + " db");
    }

    public static void feladat4(ArrayList<radiok> lista) {

        for (radiok e : lista) {
            if (e.getPerc() == 1 && e.getAdasszam() == 4) {
                System.out.println("4. feladat: Volt négy adást indító sofőr.");
                break;
            }
        }
    }

    public static void feladat5(ArrayList<radiok> lista) {
        System.out.print("5. feladat: Kérek egy nevet: ");
        Scanner be = new Scanner(System.in);
        String bekertnev = be.nextLine();
        int db = 0;
        for (radiok e : lista) {
            if (e.getSofornev().equals(bekertnev)) {
                db++;
            }

        }
        System.out.println(bekertnev+" "+db+"x"+" használta a CB-rádiót.");
    }

    
    public static void feladat7(ArrayList<radiok> lista) {

        try{
        PrintWriter pr=new PrintWriter(new FileWriter("cb2.txt"));
            for (radiok e : lista) {
              int sor=AtszamolPercre(e.getOra(), e.getPerc());
              pr.print(sor+";"+e.getSofornev()+";"+e.getAdasszam());
            }
    
        
        }catch(IOException ioe){System.out.println(ioe);}
        
    }
    
    public static void feladat8(ArrayList<radiok> lista) {
   Long soforszam = lista.stream().map(bejegyzes -> bejegyzes.getSofornev()).distinct().count();
   System.out.println("8. feladat: Sofőrök száma: " + soforszam);
    }

    public static void feladat9(ArrayList<radiok> lista) {
        
        
    }

}
