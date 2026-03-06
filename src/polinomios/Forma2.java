/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

public class Forma2 {

    //Atributos
    private int Du, VPF2[];
    //Metodos

    public Forma2(int Terminos) {
        this.Du = Terminos * 2;
        this.VPF2 = new int[Du + 1];
        VPF2[0]= Terminos;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getVPF2(int i) {
        return VPF2[i];
    }

    public void setVPF2(int d, int i) {
        this.VPF2[i] = d;
    }
    public void LlenarPoli (String Vs[]){
        int j=0;
            
        }
}
