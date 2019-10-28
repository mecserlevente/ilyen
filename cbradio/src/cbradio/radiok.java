/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cbradio;

/**
 *
 * @author User
 */
public class radiok {

public static String elsosor;
private int ora;
private int perc;
private int adasszam;
private String sofornev;

    public radiok(int ora, int perc, int adasszam, String sofornev) {
        this.ora = ora;
        this.perc = perc;
        this.adasszam = adasszam;
        this.sofornev = sofornev;
    }

 
    public int getOra() {
        return ora;
    }

    public int getPerc() {
        return perc;
    }

    public int getAdasszam() {
        return adasszam;
    }

    public String getSofornev() {
        return sofornev;
    }

    
    
}
