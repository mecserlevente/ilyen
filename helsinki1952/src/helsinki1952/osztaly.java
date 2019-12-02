/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helsinki1952;

/**
 *
 * @author felhaszn
 */
public class osztaly {
   private int helyezes;
   private int sportoloszam;
   private String sportag;
   private String versenyszam;

    public osztaly(int helyezes, int sportoloszam, String sportag, String versenyszam) {
        this.helyezes = helyezes;
        this.sportoloszam = sportoloszam;
        this.sportag = sportag;
        this.versenyszam = versenyszam;
    }

    public int getHelyezes() {
        return helyezes;
    }

    public int getSportoloszam() {
        return sportoloszam;
    }

    public String getSportag() {
        return sportag;
    }

    public String getVersenyszam() {
        return versenyszam;
    }

    public void setHelyezes(int helyezes) {
        this.helyezes = helyezes;
    }

    public void setSportoloszam(int sportoloszam) {
        this.sportoloszam = sportoloszam;
    }

    public void setSportag(String sportag) {
        this.sportag = sportag;
    }

    public void setVersenyszam(String versenyszam) {
        this.versenyszam = versenyszam;
    }
   
    
    
}
