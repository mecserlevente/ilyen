/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helsinki1952;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Helsinki1952 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<osztaly> lista = new ArrayList<osztaly>();
        beolvas(lista);

        System.out.println("3. feladat: Pontszerző helyezések száma: " + lista.size());
        int aranydb = 0;
        int ezüstdb = 0;
        int bronzdb = 0;

        for (osztaly e : lista) {
            if (e.getHelyezes() == 1) {
                aranydb++;
            }
            if (e.getHelyezes() == 2) {
                ezüstdb++;
            }
            if (e.getHelyezes() == 3) {
                bronzdb++;
            }
        }
        System.out.println("Arany érmek: " + aranydb);
        System.out.println("Ezüst érmek: " + ezüstdb);
        System.out.println("Bronz érmek: " + bronzdb);
        System.out.println("Összesen: " + (aranydb + ezüstdb + bronzdb));

        int helyezespont = 0;
        for (osztaly e : lista) {
            switch (e.getHelyezes()) {
                case 1: {
                    helyezespont += 7;
                    break;
                }
                case 2: {
                    helyezespont += 5;
                    break;
                }
                case 3: {
                    helyezespont += 4;
                    break;
                }
                case 4: {
                    helyezespont += 3;
                    break;
                }
                case 5: {
                    helyezespont += 2;
                    break;
                }
                case 6: {
                    helyezespont += 1;
                    break;
                }

            }
        }
        
        System.out.println("5. feladat: Olimpiai pontok száma: "+helyezespont);
        
        int uszasdb=0;
        int tornadb=0;
        
        for (osztaly e : lista) {
            if (e.getHelyezes()==1 || e.getHelyezes()==2 || e.getHelyezes()==3 && e.getSportag().equals("uszas")) {
                uszasdb++;
            }
           if (e.getHelyezes()==1 || e.getHelyezes()==2 || e.getHelyezes()==3 && e.getSportag().equals("torna")) {
                tornadb++;
            }  
             }
             
            if (tornadb>uszasdb) {
                System.out.println("a torna több");
            }else if (tornadb==uszasdb) {
                System.out.println("ugyanannyi");
            }else { System.out.println("az úszás több");}
           
            
      
        

    }

    public static void beolvas(ArrayList<osztaly> lista) {

        try {

            File adat = new File("helszinki.txt");
            Scanner fileinput = new Scanner(adat);
            while (fileinput.hasNextLine()) {
                String data = fileinput.nextLine();
                String[] tomb = data.split(" ");

                lista.add(new osztaly(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), tomb[2], tomb[3]));

            }
            fileinput.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
