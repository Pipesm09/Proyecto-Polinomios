/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author ASUS
 */
public class Forma3 {

    //Atributos
    private Nodo Punta;
    //Métodos

    public Forma3() {
        this.Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public void InsertarFinal(int Coe, int Exp) {
        Nodo p = Punta, x = new Nodo(Coe, Exp);

        if (Punta == null) {
            Punta = x;
        } else {
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }
    }
    public void LlenarPoli (String Vs[]){
        int j=0;
            
        }
}
