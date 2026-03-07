package polinomios;

/**
 *
 * @author Andres Sossa, Juan Felipene Sanchezzzzzzzz
 */
public class Forma1 {

    private int Du;
    private int VPF1[];

    public Forma1(int Grado) {
        this.Du = Grado + 1;
        this.VPF1 = new int[Du + 1];
        VPF1[0] = Grado;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public void setVPF1(int[] VPF1) {
        this.VPF1 = VPF1;
    }

    public int getVPF1(int i) {
        return VPF1[i];
    }

    public void setVPF1(int d, int i) {
        this.VPF1[i] = d;
    }

    public void Insertar(int coe, int exp) {
        if (VPF1 == null) {
            VPF1 = new int[exp + 2];
            VPF1[0] = exp;
            VPF1[exp + 1] = coe;
            return;
        }
        if (exp > VPF1[0]) {
            int nuevoGrado = exp;
            int[] Va = new int[nuevoGrado + 2];
            Va[0] = nuevoGrado;
            Va[1] = coe;

            for (int i = VPF1.length - 1; i >= 1; i--) {
                Va[i] = VPF1[i];
            }
            Va[exp + 1] = coe;
            VPF1 = Va;
        } else {
            int indice = VPF1[0] - exp + 1;
            VPF1[indice] += coe;
        }
    }

    public void Eliminar(int exp) {
        if (VPF1 == null) {
            return;
        }
        if (exp > VPF1[0]) {
            System.out.println("El termino que desea utilizar no se encuentra en este polinomio");
            return;
        }
        VPF1[exp + 1] = 0;
        if (exp == VPF1[0]) {
            int nuevoGrado = 0;
            for (int i = VPF1[0] - 1; i >= 0; i--) {
                if (VPF1[i + 1] != 0) {
                    nuevoGrado = i;
                    break;
                }
            }

            // Si el polinomio se quedó vacío (todo ceros)
            if (nuevoGrado == 0 && VPF1[1] == 0) {
                VPF1 = new int[2];
                VPF1[0] = 0;
                return;
            }
            int[] Va = new int[nuevoGrado + 2];
            Va[0] = nuevoGrado;
            for (int i = 1; i < Va.length; i++) {
                Va[i] = VPF1[i];
            }
            VPF1 = Va;
        }
    }

    public void LlenarPoli(String[] Vs) {
        for (int i = 0; i < Vs.length - 1; i += 2) {
            if (Vs[i] == null || Vs[i + 1] == null) {
                break;
            }
            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i + 1]);
            this.Insertar(coe, exp);
        }
    }

    public void MostrarForma() {

        if (VPF1 == null) {
            System.out.println("El polinomio esta vacio.");
            return;
        }
        System.out.println("El grado: " + VPF1[0]);
        for (int i = VPF1.length - 1; i >= 1; i--) {
            System.out.print("[" + VPF1[i] + "] ");
        }

    }
    public String ReconstruirPoli() {
        if (VPF1 == null) return "El vector es NULO (vacío)";

        int grado = VPF1[0];        
        String resultado = "";
        boolean esPrimerTermino = true;
        for (int k = grado; k >= 0; k--) {
            int pos = k + 1;
            
            // Si la posición se sale del vector, avisamos
            if (pos >= VPF1.length) {
                System.out.println("SALTANDO pos " + pos + " (fuera de rango)");
                continue; 
            }

            int coe = VPF1[pos];
            if (coe != 0) {
                if (esPrimerTermino) {
                    if (coe < 0) resultado += "-";
                } else {
                    if (coe > 0) resultado += " + ";
                    else resultado += " - ";
                }
                int valor =coe;
                if(valor<0){
                    valor=-valor;
                }
                if (valor !=1 || k == 0) {
                    resultado += valor;
                }
                if (k > 0) {
                    resultado += "x";
                }
                if (k > 1) {
                    resultado += "^" + k;
                }
                esPrimerTermino = false;
            }
        }

        System.out.println(resultado);
        
        if (resultado.equals("")) return "0";
        return resultado;
    }

    public static void SumarPoli(Forma1 vector1, Forma1 vector2) {

        int gradoSuma = Math.max(vector1.VPF1[0], vector2.VPF1[0]);

        Forma1 VecSuma = new Forma1(gradoSuma);

        int i;
        int coef1;
        int coef2;
        int suma;
        int exp;

        for (i = 1; i <= gradoSuma + 1; i++) {

            coef1 = 0;
            coef2 = 0;

            if (i < vector1.VPF1.length) {
                coef1 = vector1.VPF1[i];
            }

            if (i < vector2.VPF1.length) {
                coef2 = vector2.VPF1[i];
            }

            suma = coef1 + coef2;

            exp = gradoSuma - (i - 1);

            VecSuma.Insertar(suma, exp);
        }

        System.out.println("La suma de los polinomios es:");

        System.out.println("\n");
        for (i = 0; i < VecSuma.VPF1.length; i++) {
            System.out.print("[" + VecSuma.VPF1[i] + "]");
        }
        System.out.println("\n");
    }

    public static void MultiplicarPoli(Forma1 vector1, Forma1 vector2) {

        int gradoResultado = vector1.VPF1[0] + vector2.VPF1[0];
        Forma1 VecRes = new Forma1(gradoResultado);

        for (int i = 1; i < vector1.VPF1.length; i++) {

            int coef1 = vector1.VPF1[i];
            int exp1 = vector1.VPF1[0] - (i - 1);

            for (int j = 1; j < vector2.VPF1.length; j++) {

                int coef2 = vector2.VPF1[j];
                int exp2 = vector2.VPF1[0] - (j - 1);

                int coefRes = coef1 * coef2;
                int expRes = exp1 + exp2;

                VecRes.Insertar(coefRes, expRes);
            }
        }

        System.out.println("\n");
        for (int i = 0; i < VecRes.VPF1.length; i++) {
            System.out.print("[" + VecRes.VPF1[i] + "]");
        }
        System.out.println("\n");
    }

    public double evaluar(double x) {

        double resultado = 0;

        for (int i = 1; i < VPF1.length; i++) {

            int coef = VPF1[i];
            int exp = VPF1[0] - (i - 1);

            resultado += coef * Math.pow(x, exp);
        }

        return resultado;
    }
}
