/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telefon;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Telefon {

    public static class hivasadatok {

        LocalTime kezdet;
        LocalTime veg;
        int mp;

        public hivasadatok(LocalTime kezdet, LocalTime veg, int mp) {
            this.kezdet = kezdet;
            this.veg = veg;
            this.mp = mp;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<hivasadatok> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("3. feladat");
        int oradb = 0;
        int kezdetosszehasonlitas;
        int vegosszehasonlitas;
        for (int i = 0; i < 24; i++) {
            oradb = 0;
            for (hivasadatok e : lista) {
                vegosszehasonlitas = e.kezdet.compareTo(LocalTime.of(i, 59, 59));
                kezdetosszehasonlitas = e.kezdet.compareTo(LocalTime.of(i, 0, 0));
                if (vegosszehasonlitas < 0 && kezdetosszehasonlitas >= 0) {
                    oradb++;
                }

            }
            if (oradb == 0) {

            } else {
                System.out.println(i + " óra " + oradb + " hívás");
            }

        }
        System.out.println("4. feladat");
        int maxora = 0;
        int maxorahelye = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).mp > maxora) {
                maxora = lista.get(i).mp;
                maxorahelye = i + 1;
            }

        }
        System.out.println("A leghosszabb hívás " + maxora + " mp hosszú volt, és a " + maxorahelye + ". sorban szerepel.");
        System.out.println("5. feladat");
        System.out.println("Adjon meg egy idopontot! (ora perc masodperc)");
        Scanner beora = new Scanner(System.in);
        Scanner beperc = new Scanner(System.in);
        Scanner bemp = new Scanner(System.in);
        LocalTime bekertido = LocalTime.of(beora.nextInt(), beperc.nextInt(), bemp.nextInt());

        int szamlalo = 0;
        for (int i = 0; i < lista.size(); i++) {
            if ((bekertido.compareTo(lista.get(i).kezdet)) >= 0 && bekertido.compareTo(lista.get(i).veg) <= 0) {
                szamlalo++;
                if (szamlalo == 1) {
                    System.out.println(i + 1);
                }

            }
        }

        if (szamlalo == 0) {
            System.out.println("nem volt hívás");
        } else {
            if (szamlalo == 1) {

            } else {
                System.out.println(szamlalo - 1);
            }
        }

        LocalTime sikeresbeszedveg = LocalTime.of(0, 0, 0);
        LocalTime utolsoelottiveg = LocalTime.of(0, 0, 0);
        Boolean utolsoelotti = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).veg.compareTo(LocalTime.of(8, 0, 0)) > 0) {
//                System.out.println(lista.get(i).kezdet + "-"+lista.get(i).veg);
                if (lista.get(i).veg.compareTo(sikeresbeszedveg) > 0) {
                    sikeresbeszedveg = lista.get(i).veg;
                    if (sikeresbeszedveg.compareTo(LocalTime.of(12, 0, 0)) > 0) {
                        if (utolsoelotti == false) {
                            utolsoelotti = true;
                            utolsoelottiveg = sikeresbeszedveg;
                        } else {
                            System.out.println("megvan az utolsó");
                            System.out.println(lista.get(i).kezdet);
                            System.out.println(utolsoelottiveg.toSecondOfDay() - lista.get(i).kezdet.toSecondOfDay());
                            break;
                            
                        }
                        
                    }

                }

            }

        }
        
        
//        System.out.println(utolsoelottiveg);

    PrintWriter pr=new PrintWriter(new FileWriter("sikeres.txt"));

        sikeresbeszedveg=LocalTime.of(8, 0, 0);
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).veg.compareTo(LocalTime.of(8, 0, 0)) >= 0 && lista.get(i).kezdet.compareTo(LocalTime.of(12, 0, 0)) <= 0) {
                if (lista.get(i).veg.compareTo(sikeresbeszedveg) > 0) {
                    pr.print(i+1 + " " + sikeresbeszedveg.getHour()+" "+sikeresbeszedveg.getMinute()+" " + sikeresbeszedveg.getSecond()+" "
                            + lista.get(i).veg.getHour()+" "+lista.get(i).veg.getMinute()+" "+lista.get(i).veg.getSecond()+"\n");
                    sikeresbeszedveg = lista.get(i).veg;
                }
            }
            
        }
pr.close();

    }

    public static void beolvas(ArrayList<hivasadatok> lista) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("hivas.txt"));
        int kezdetmp;
        int zaromp;
        int asd;
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            kezdetmp = mpbe(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]));
            zaromp = mpbe(Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]));
            asd = zaromp - kezdetmp;
            lista.add(new hivasadatok(LocalTime.of(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2])),
                    LocalTime.of(Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5])), asd));
        }
        fileinput.close();

    }

    public static int mpbe(int ora, int perc, int masodperc) {

        int masodp = ((ora * 60) * 60) + (perc * 60) + masodperc;

        return masodp;
    }
     
}
