/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author ASUS
 */
public class Nodo {
    //Atributos
    private int Coe, Exp;
    private Nodo Liga;
    
    //Métodos

    public Nodo(int Coe, int Exp) {
        this.Coe = Coe;
        this.Exp = Exp;
        this.Liga = null;
    }

    public int getCoe() {
        return Coe;
    }

    public void setCoe(int Coe) {
        this.Coe = Coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }

    public Nodo getLiga() {
        return Liga;
    }

    public void setLiga(Nodo Liga) {
        this.Liga = Liga;
    }
    
}
