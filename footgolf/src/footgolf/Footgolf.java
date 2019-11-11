/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footgolf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Footgolf {

    public String xx;

    public static void main(String[] args) {
    Scanner bekertnev = new Scanner(System.in);

        ArrayList<golfosztaly> lista = new ArrayList<golfosztaly>();
        beolvas(lista);
        System.out.println("3. feladat: Versenyzők száma: " + lista.size());
        System.out.println("4. feladat: " + String.format("%.2f ", feladat4(lista)) + "%");
        System.out.println("Írj be egy nevet");

       
        String be=bekertnev.nextLine();
        System.out.println( feladat5(lista, be)); 
//        feladat5(lista, "Sain Antal");

    }

    public static void beolvas(ArrayList<golfosztaly> lista) {
        try {
            File adat = new File("fob2016.txt");
            Scanner fileinput = new Scanner(adat);
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String[] tomb = data.split(";");

                lista.add(new golfosztaly(tomb[0], tomb[1], tomb[2], Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]),
                        Integer.parseInt(tomb[6]), Integer.parseInt(tomb[7]), Integer.parseInt(tomb[8]), Integer.parseInt(tomb[9]), Integer.parseInt(tomb[10])));

            }
            fileinput.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static double feladat4(ArrayList<golfosztaly> lista) {

        double noidb = 0;
        double osszesdb = lista.size();
        for (golfosztaly e : lista) {
            if (e.getKategoria().equals("Noi")) {
                noidb++;
            }
        }
        double eredmeny = (noidb / osszesdb) * 100;

        return eredmeny;
    }

    public static int feladat5(ArrayList<golfosztaly> lista, String bekertnev2) {

        int osszpontszam = 0;
        String x1 = bekertnev2;
        String x2;

        int tomb2[] = new int[8];

        for (int i = 0; i < lista.size(); i++) {
            x2 = lista.get(i).getVersenyzonev();
//                System.out.println("lista.get(i).getVersenyzonev(): *"+lista.get(i).getVersenyzonev()+"*");
//                System.out.println("bekertnev: *"+bekertnev+"*");
            if (x1.equals(x2)) {
                tomb2[0] = lista.get(i).getElsopont();
                tomb2[1] = lista.get(i).getMasodikpont();
                tomb2[2] = lista.get(i).getHarmadikpont();
                tomb2[3] = lista.get(i).getNegyedikpont();
                tomb2[4] = lista.get(i).getOtodikpont();
                tomb2[5] = lista.get(i).getHatodikpont();
                tomb2[6] = lista.get(i).getHetedikpont();
                tomb2[7] = lista.get(i).getNyolcadikpont();
                   /*for (int j = 0; j < 8; j++) {
                       System.out.println("elotte: "+tomb2[j]);
                    }*/

                   Arrays.sort(tomb2);
            
                /*for (int j = 0; j < 8; j++) {
                    System.out.println("utana: "+tomb2[j]);
                }*/
                
            
                if (tomb2[0]>0) {
                    osszpontszam=osszpontszam+10;
                }
            if (tomb2[1]>0) {
                    osszpontszam=osszpontszam+10;
                }
            osszpontszam=osszpontszam+tomb2[2]+tomb2[3]+tomb2[4]+tomb2[5]+tomb2[6]+tomb2[7];
            
            
            
            }

        }
return osszpontszam;
    }

}
