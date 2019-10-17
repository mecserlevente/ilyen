/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tesztverseny;

/**
 *
 * @author User
 */
public class Class {
 
    public static String helyesvalasz;
    private String azonosito;
    private String valasz;

    public Class(String azonosito, String valasz) {
        this.azonosito = azonosito;
        this.valasz = valasz;
    }

    public String getAzonosito() {
        return azonosito;
    }

    public String getValasz() {
        return valasz;
    }
    
}
