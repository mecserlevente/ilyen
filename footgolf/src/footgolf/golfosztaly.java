/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footgolf;

/**
 *
 * @author felhaszn
 */
public class golfosztaly {
    
  private String versenyzonev;
  private String kategoria;
  private String egyesulet;
  private int elsopont;
  private int masodikpont;
  private int harmadikpont;
  private int negyedikpont;
  private int otodikpont;
  private int hatodikpont;
  private int hetedikpont;
  private int nyolcadikpont;

    public golfosztaly(String versenyzonev, String kategoria, String egyesulet, int elsopont, int masodikpont, int harmadikpont, int negyedikpont, int otodikpont, int hatodikpont, int hetedikpont, int nyolcadikpont) {
        this.versenyzonev = versenyzonev;
        this.kategoria = kategoria;
        this.egyesulet = egyesulet;
        this.elsopont = elsopont;
        this.masodikpont = masodikpont;
        this.harmadikpont = harmadikpont;
        this.negyedikpont = negyedikpont;
        this.otodikpont = otodikpont;
        this.hatodikpont = hatodikpont;
        this.hetedikpont = hetedikpont;
        this.nyolcadikpont = nyolcadikpont;
    }

    public String getVersenyzonev() {
        return versenyzonev;
    }

    public String getKategoria() {
        return kategoria;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public int getElsopont() {
        return elsopont;
    }

    public int getMasodikpont() {
        return masodikpont;
    }

    public int getHarmadikpont() {
        return harmadikpont;
    }

    public int getNegyedikpont() {
        return negyedikpont;
    }

    public int getOtodikpont() {
        return otodikpont;
    }

    public int getHatodikpont() {
        return hatodikpont;
    }

    public int getHetedikpont() {
        return hetedikpont;
    }

    public int getNyolcadikpont() {
        return nyolcadikpont;
    }
  
  
    
}
