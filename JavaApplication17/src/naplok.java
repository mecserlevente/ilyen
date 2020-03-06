/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MECLEVAA
 */
public class naplok {
   
   String tegvagykeresztnev; 
   String honapvagyvezeteknev;
   String napvagykeresztnev;

    public naplok(String tegvagykeresztnev, String honapvagyvezeteknev, String napvagykeresztnev) {
        this.tegvagykeresztnev = tegvagykeresztnev;
        this.honapvagyvezeteknev = honapvagyvezeteknev;
        this.napvagykeresztnev = napvagykeresztnev;
    }

    public String getTegvagykeresztnev() {
        return tegvagykeresztnev;
    }

    public String getHonapvagyvezeteknev() {
        return honapvagyvezeteknev;
    }

    public String getNapvagykeresztnev() {
        return napvagykeresztnev;
    }
   
   
}
