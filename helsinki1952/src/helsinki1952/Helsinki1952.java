/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helsinki1952;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
                helyezespont+=pontszam(e.getHelyezes());
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
           
            try{
            PrintWriter pr=new PrintWriter(new FileWriter("helsinki2.txt"));
            
            
                String kajakkenu = "";
                for (osztaly e : lista) {
//                    System.out.println("e.getSportag():"+e.getSportag());
                    if (e.getSportag().contains("kajak")) {
                        kajakkenu = "kajak-ke-nu";
                    } else {
                        kajakkenu = e.getSportag();
                    }
         
                    pr.println(e.getHelyezes()+" "+e.getSportoloszam()+" "+pontszam(e.getHelyezes())+" "+kajakkenu+" "+e.getVersenyszam());
                    
                }

            
            pr.close();
            } catch(IOException ioe){System.out.println(ioe);}
      
        int max=0;
       int maxindex=0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getSportoloszam()>max) {
                max=lista.get(i).getSportoloszam();
                maxindex=i;
            }
        }
        
        System.out.println("max: "+lista.get(maxindex).getSportag());
        
        

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
    
    public static int pontszam(int helyezes){
     int helyezespont=0;
        switch (helyezes) {
                case 1: {
                    helyezespont = 7;
                    break;
                }
                case 2: {
                    helyezespont = 5;
                    break;
                }
                case 3: {
                    helyezespont = 4;
                    break;
                }
                case 4: {
                    helyezespont = 3;
                    break;
                }
                case 5: {
                    helyezespont = 2;
                    break;
                }
                case 6: {
                    helyezespont = 1;
                    break;
                }

    
    }
    return helyezespont;
    
}

}
