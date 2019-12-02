/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lezerloveszet;

/**
 *
 * @author felhaszn
 */
public class jatekosok {
    private String nev2;
    private int lovesszam;
    private double pontszam2;

   
    public jatekosok(String nev2, int lovesszam,double pontszam2) {
        this.nev2 = nev2;
        this.lovesszam = lovesszam;
        this.pontszam2 = pontszam2; 
    }

    public String getNev2() {
        return nev2;
    }

    public int getLovesszam() {
        return lovesszam;
    }

    public void setNev2(String nev2) {
        this.nev2 = nev2;
    }

    public void setLovesszam(int lovesszam) {
        this.lovesszam = lovesszam;
    }

    public double getPontszam2() {
        return pontszam2;
    }

    public void setPontszam2(double pontszam2) {
        this.pontszam2 = pontszam2;
    }
    
    
    
}
