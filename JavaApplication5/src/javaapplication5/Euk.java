package javaapplication5;


import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MECLEVAA
 */
public class Euk {
   private String orszagnev;
    private LocalDate datum;

    public Euk(String orszagnev, LocalDate datum) {
        this.orszagnev = orszagnev;
        this.datum = datum;
    }

    public String getOrszagnev() {
        return orszagnev;
    }

    public LocalDate getDatum() {
        return datum;
    }

    
}
