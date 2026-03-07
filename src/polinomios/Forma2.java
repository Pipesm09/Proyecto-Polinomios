/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

public class Forma2 {

    //Atributos
    private int du, VPF2[];
    //Metodos

    public Forma2(int Terminos) {
        this.du = Terminos * 2;
        this.VPF2 = new int[du + 1];
        VPF2[0] = Terminos;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
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
    public void LlenarPoli2(String[] Vs) {
        for (int i = 0; i < Vs.length - 1; i += 2) {
            if (Vs[i] == null || Vs[i + 1] == null) {
                break;
            }

            String sCoef = Vs[i];
            String sExp = Vs[i + 1];

            // Protecciones para "x" solas o vacíos
            if (sCoef.equals("") || sCoef.equals("+")) {
                sCoef = "1";
            } else if (sCoef.equals("-")) {
                sCoef = "-1";
            }

            if (sExp.equals("")) {
                sExp = "1";
            }

            try {
                int coe = Integer.parseInt(sCoef);
                int exp = Integer.parseInt(sExp);
                this.InsertarF2(coe, exp);
            } catch (NumberFormatException e) {
                // Ignoramos basura
            }
        }
    }

    public void InsertarF2(int coe, int exp) {
        if (VPF2 == null) {
            VPF2 = new int[3];
            VPF2[0] = 1;
            VPF2[1] = coe;
            VPF2[2] = exp;
            return;
        }
        int terminos = VPF2[0];
        int posicion = 1;
        //quiere decir que va a romper si el termino a insertar no tiene exponente igual en el polinomio
        while (posicion < du + 1 && VPF2[posicion + 1] > exp) {
            posicion += 2;
        }
        if (posicion < du + 1 && VPF2[posicion + 1] == exp) {
            VPF2[posicion] = VPF2[posicion] + coe;
        }
        int[] va=  new int[du + 3];
        va[0] = terminos + 1;
        //la idea es recorrer hasta posicion, para luego mandar a los que estaban ahi mas atras en el vector Va
        for (int i = 0; i < posicion; i++) {
            va[i] = VPF2[i];
        }
        va[posicion] = coe;
        va[posicion   + 1] = exp;
        //se llena lo que quedo a la derecha
        for (int i = posicion; i < du + 1; i++) {
            va[i] = VPF2[i];
        }
        VPF2 = va;
    }

    public void MostrarForma2() {
        if (VPF2 == null) {
            System.out.println("El polinomio esta vacio.");
            return;
        }
        System.out.println("Numero de terminos: " + VPF2[0]);
        for (int i = 1; i < VPF2[0] * 2 + 1; i += 2) {
            System.out.print("[" + VPF2[i] + "][" + VPF2[i + 1] + "] ");
        }
        System.out.println();
    }
}
