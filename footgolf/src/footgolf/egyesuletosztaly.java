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
class egyesuletosztaly {
    private String egyesulet;
    private int letszam;

    public egyesuletosztaly(String egyesulet, int letszam) {
        this.egyesulet = egyesulet;
        this.letszam = letszam;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public int getLetszam() {
        return letszam;
    }

    public void setEgyesulet(String egyesulet) {
        this.egyesulet = egyesulet;
    }

    public void setLetszam(int letszam) {
        this.letszam = letszam;
    }

    
}
