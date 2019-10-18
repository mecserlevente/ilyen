/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author MECLEVAA
 */
public class stadions {
    private String varosneve;
    private String stadionneve;
    private String alternativneve;
    private int ferohely;

    public stadions(String varosneve, String stadionneve, String alternativneve, int ferohely) {
        this.varosneve = varosneve;
        this.stadionneve = stadionneve;
        this.alternativneve = alternativneve;
        this.ferohely = ferohely;
    }

    public String getVarosneve() {
        return varosneve;
    }

    public String getStadionneve() {
        return stadionneve;
    }

    public String getAlternativneve() {
        return alternativneve;
    }

    public int getFerohely() {
        return ferohely;
    }
    
    
}
