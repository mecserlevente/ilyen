/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package furdostat;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author felhaszn
 */
public class Furdostat {

    public static class adatok {

        int vendegazon;
        int reszlegazon;
        int bevagyki;
        LocalTime ido;

        public adatok(int vendegazon, int reszlegazon, int bevagyki, LocalTime ido) {
            this.vendegazon = vendegazon;
            this.reszlegazon = reszlegazon;
            this.bevagyki = bevagyki;
            this.ido = ido;
        }

    }

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<adatok> lista = new ArrayList<>();

        File adat = new File("furdoadat.txt");
        Scanner fileinput = new Scanner(adat);
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            String tomb[] = data.split(" ");
            lista.add(new adatok(Integer.parseInt(tomb[0]), Integer.parseInt(tomb[1]), Integer.parseInt(tomb[2]), LocalTime.of(Integer.parseInt(tomb[3]), Integer.parseInt(tomb[4]), Integer.parseInt(tomb[5]))));

        }
        fileinput.close();

        System.out.println("2.feladat: ");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).reszlegazon == 0 && lista.get(i).bevagyki == 1) {
                System.out.println("Az első vendég " + lista.get(i).ido + "-kor lépett ki az öltözőből.");
                break;
            }
        }

        for (int i = lista.size() - 1; i > 0; i--) {
            if (lista.get(i).reszlegazon == 0 && lista.get(i).bevagyki == 1) {
                System.out.println("az utolsó vendég " + lista.get(i).ido + "-kor lépett ki az öltözőből.");
                break;
            }

        }

        int db = 0;
        int db2 = 0;
        for (int i = 0; i < lista.size(); i++) {
            db = 1;
            int j;
            for (j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).vendegazon == lista.get(j).vendegazon) {
                    db++;
                } else {
                    if (db == 4) {
                        db2++;
                    }
                    break;
                }

            }
            i = j - 1;

        }
        System.out.println("3.feladat");
        System.out.println("A furdőben csak "+db2+" vendég járt csak egy részlegen.");

        
        LocalTime maxidotartam = LocalTime.of(0, 0, 0);
        int maxidotartamvendeg = 0;
        LocalTime kezdoido,zaroido ;
        for (int i = 0; i < lista.size(); i++) {
            kezdoido = lista.get(i).ido;
            int j;
            for (j = i + 1; j < lista.size(); j++) {
                if (lista.get(i).vendegazon == lista.get(j).vendegazon) {
                    zaroido = lista.get(j).ido;
                } else {
                    System.out.println("eltelt idő: "+(zaroido-kezdoido));
                    //annak vizsgálata, hogy ez nagyobb-e az eddigi max időtartamnál        
                    break;
                }

            }
            i = j - 1;

        }
        
        
        
        
        
    }

}
