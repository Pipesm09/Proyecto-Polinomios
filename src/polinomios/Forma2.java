/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

public class Forma2 {

    private int VPF2[];
    private int du;

    public Forma2(int terminos) {
        this.du = terminos * 2;
        this.VPF2 = new int[du + 1];
        VPF2[0] = 0;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getDu() {
        return du;
    }

    public void setDu(int du) {
        this.du = du;
    }

    public int getVPF2(int i) {
        return VPF2[i];
    }

    public void setVPF2(int d, int i) {
        this.VPF2[i] = d;
    }

    public void LlenarPoli2(String[] Vs) {
        //esto garantiza que se lea todas las pajeras
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
        while (posicion < terminos * 2 + 1 && VPF2[posicion + 1] > exp) {
            posicion += 2;
        }
        if (posicion < terminos * 2 + 1 && VPF2[posicion + 1] == exp) {
            VPF2[posicion] = VPF2[posicion] + coe;
            if (VPF2[posicion] == 0) {
                EliminarF2(exp);
            }
            return;
        }

        int[] va=  new int[(terminos + 1) * 2 + 1];
        va[0] = terminos + 1;
        //la idea es recorrer hasta posicion, para luego mandar a los que estaban ahi mas atras en el vector Va
        for (int i = 1; i < posicion; i++) {
            va[i] = VPF2[i];
        }
        va[posicion] = coe;
        va[posicion       + 1] = exp;
        //se llena lo que quedo a la derecha
        for (int i = posicion; i < terminos * 2 + 1; i++) {
            va[i     + 2] = VPF2[i];
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

    public void EliminarF2(int exp) {

        if (VPF2 == null || VPF2[0] == 0) {
            System.out.println("Erorr");
        }
        int pos = 1;
        int terminos = VPF2[0];
        //se busca la posicion a eliminar
        while (pos < terminos * 2 + 1 && VPF2[pos + 1] != exp) {
            pos += 2;
        }
        //no se encontro
        if (pos >= terminos * 2 + 1) {
            System.out.println("erorr");;
            return;
        }
        //por si solo hay un termino
        if (terminos == 1) {
            VPF2 = null;
            return;
        }
        //creo vector mas pequeño
        int[] va=  new int[(terminos - 1) * 2 + 1];
        va[0] = terminos - 1;
        //gguardar hasta el temrino a eliminar
        for (int i = 1; i < pos; i++) {
            va[i] = VPF2[i];
        }
        //salto al termino que quiero eliminar y tiro lo que este a la derecha de el hacia atras
        for (int i = pos + 2; i < terminos * 2 + 1; i++) {
            va[i     - 2] = VPF2[i];
        }
        VPF2 = va;
        System.out.println("Término eliminado melo.");
    }

    public static void SumarPoliF2(Forma2 vector1, Forma2 vector2) {

        Forma2 VecSuma = new Forma2(vector1.VPF2[0] + vector2.VPF2[0]);

        for (int i = 1; i < vector1.VPF2[0] * 2 + 1; i += 2) {
            VecSuma.InsertarF2(vector1.VPF2[i], vector1.VPF2[i + 1]);
        }

        for (int i = 1; i < vector2.VPF2[0] * 2 + 1; i += 2) {
            VecSuma.InsertarF2(vector2.VPF2[i], vector2.VPF2[i + 1]);
        }

        System.out.println("\nLa suma de los polinomios es:\n");

        for (int i = 0; i < VecSuma.VPF2.length; i++) {
            System.out.print("[" + VecSuma.VPF2[i] + "]");
        }

        System.out.println("\n");
    }

    public static void MultiplicarPoliF2(Forma2 vector1, Forma2 vector2) {

        int Terminos = vector1.VPF2[0] * vector2.VPF2[0];
        Forma2 VecRes = new Forma2(Terminos);

        for (int i = 1; i < vector1.VPF2.length; i+=2) {

            int coef1 = vector1.VPF2[i];
            int exp1 = vector1.VPF2[i+1];

            for (int j = 1; j < vector2.VPF2.length; j+=2) {

                int coef2 = vector2.VPF2[j];
                int exp2 = vector2.VPF2[j+1];

                int coefRes = coef1 * coef2;
                int expRes = exp1 + exp2;

                VecRes.InsertarF2(coefRes, expRes);
            }
        }
        System.out.println("\n");
        for (int i = 0; i < VecRes.VPF2.length; i++) {
            System.out.print("[" + VecRes.VPF2[i] + "]");
        }
        System.out.println("\n");
    }
}
