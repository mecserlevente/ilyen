package tanfel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tanfel {

    public static class beosztasok {

        String tanar;
        String tantargy;
        String osztaly;
        int oraszam;

        public beosztasok(String tanar, String tantargy, String osztaly, int oraszam) {
            this.tanar = tanar;
            this.tantargy = tantargy;
            this.osztaly = osztaly;
            this.oraszam = oraszam;
        }

    }

    public static class ofi {

        String osztaly;
        String tanar;

        public ofi(String osztaly, String tanar) {
            this.osztaly = osztaly;
            this.tanar = tanar;
        }

    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<beosztasok> lista = new ArrayList<>();
        beolvas(lista);
        System.out.println("2. feladat:" + lista.size());
        int oradb = 0;
        for (beosztasok object : lista) {
            oradb = Integer.sum(object.oraszam, oradb);
        }
        System.out.println("3. feladat" + oradb);
        System.out.println("Írj be egy nevet!!");
        Scanner be = new Scanner(System.in);
        String bekertnev = be.nextLine();
        int tanaroradb = 0;
        for (beosztasok object : lista) {
            if (bekertnev.equals(object.tanar)) {
                tanaroradb = Integer.sum(object.oraszam, tanaroradb);
            }

        }

        System.out.println("4. feladat:" + tanaroradb);

        ArrayList<ofi> tanarlista = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).tantargy.equals("osztalyfonoki")) {

                tanarlista.add(new ofi(lista.get(i).osztaly, lista.get(i).tanar));
            }
        }
        PrintWriter pr = new PrintWriter(new FileWriter("of.txt"));
        for (ofi object : tanarlista) {
            pr.print(object.osztaly + "-" + object.tanar + "\n");
        }
        pr.close();
        System.out.println("Írd be az osztályt");
        Scanner be2 = new Scanner(System.in);
        String bekertosztaly = be2.nextLine();
        System.out.println("Írd be a tantárgyat");
        Scanner be3 = new Scanner(System.in);
        String bekerttantargy = be3.nextLine();
        int tanarszamlalo = 0;
        for (int i = 0; i < lista.size(); i++) {

            if (bekertosztaly.equals(lista.get(i).osztaly) && bekerttantargy.equals(lista.get(i).tantargy)) {
                tanarszamlalo++;
            }

        }

        switch (tanarszamlalo) {
            case 0:
                System.out.println("Rossz adat");
                break;
            case 1:
                System.out.println("osztályszinten tanulják");
                break;
            default:
                System.out.println("Csoportbontás");

        }

        Long tanarok=lista.stream().map(mapper -> mapper.tanar).distinct().count();
        System.out.println("tanardb"+tanarok);
        
    }

    public static void beolvas(ArrayList<beosztasok> lista) throws FileNotFoundException {
        Scanner fileinput = new Scanner(new File("beosztas.txt"));
        int szamlalo = 0;
        String tomb[] = new String[4];
        while (fileinput.hasNextLine()) {
            String data = fileinput.nextLine();
            tomb[szamlalo] = data;
            szamlalo++;
            if (szamlalo == 4) {
                lista.add(new beosztasok(tomb[0], tomb[1], tomb[2], Integer.parseInt(tomb[3])));
                szamlalo = 0;
            }
        }
        fileinput.close();

    }

}
