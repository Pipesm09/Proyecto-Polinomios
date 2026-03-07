package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author Andres Sossa, Juan Felipzzz sanchez
 */
public class Polinomios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//-10+8x^2-3x^5+2x 4x^2+5x^3-20
        int opt = 0;
        Forma1 F1;
        String vs[] = CrearPoli();
        F1 = new Forma1(Integer.parseInt(vs[1]));
        F1.LlenarPoli(vs);
        String vs1[] = CrearPoli();
        Forma1 F12 = new Forma1 (Integer.parseInt(vs1[1]));
        F12.LlenarPoli(vs1);
        


        /**
         * Forma2 F2 = new Forma2(NumeroTerminos())
         *
         * Forma3 F3 = new Forma3(Pene);
         *
         */
        do {
            opt = menu();
            switch (opt) {
                case 1:
                    //insertar coeficiente y exponente;
                    F1.MostrarForma();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    Forma1.SumarPoli(F1,F12);
                    break;
                case 6:
                    Forma1.MultiplicarPoli(F1, F12);
                    break;
                case 7:
                    double x=0;
                    x = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x para evaluar el polinomio"));
                    double resultado = F1.evaluar(x);
                    System.out.print("El resultado del polinomio cuando x =" +x+" es igual a: "+resultado);
                    break; 
                default:
                    System.out.println("");

            }
        } while (true);
    }

    public static int menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog("****Menu pricipal****\n"
                + "1. Mostar\n" + "2. Insertar\n" + "3. Sumar\n" + "4. Multiplicar\n" + "5. Salir"));
        return opc;
    }

    public static int NumeroTerminos(String Vs[]) {
        int cont = 0;
        //Ciclo para contar

        return cont;
    }

    public static String[] CrearPoli() {
        String cadena = JOptionPane.showInputDialog("ingrese el polinomio");
        char vc[] = cadena.toCharArray();
        String vs[] = new String[vc.length], s = "";
        boolean tieneX = false;
        int i = 0;
        int j = 0;
        for (i = 0; i < vc.length; i++) {
            System.out.print("[" + vc[i] + "]");
        }
        for (i = 0; i < vc.length; i++) {
            if (vc[i] == '-' || Character.isDigit(vc[i])) {
                s += vc[i];
                if (i + 1 < vc.length && (vc[i + 1] == '+' || vc[i + 1] == '-')) {
                    vs[j] = s;
                    vs[j + 1] = "0";
                    j += 2;
                    s = "";
                } else {
                }
            } else {
                
                if (vc[i] == 'x') {
                    if (s.equals("") || s.equals("+")) {
                        vs[j] = "1";
                    } else if (s.equals("-")) {
                        vs[j] = "-1";
                    } else {
                        vs[j] = s;
                    }
                    j++;
                    s = "";
                    if (i + 1 < vc.length && vc[i + 1] == '^') {
                    } else {
                        vs[j]="1";
                        j++;
                    }
                } else {
                    if (vc[i] != '^') {
                        vs[j + 1] = "1";
                    } else {
                        vs[j] = Character.toString(vc[i + 1]);
                        j++;
                        i++;
                    }
                }
            }
        }
        if (!s.equals("")) {
            vs[j] = s;
            vs[j + 1] = "0";
        }

        System.out.println("\n");
        for (i = 0; i < vs.length; i++) {
            System.out.print("[" + vs[i] + "]");
        }
        //ordenar vector
        String Acoe;
        String AExp;
        boolean Cambio=true;
        while(Cambio){
            Cambio=false;
            for (i = 1; i < vs.length; i += 2) {
                j = i + 2;
                if (vs[i] != null && vs[j] != null) {
                    if (Integer.parseInt(vs[i]) < Integer.parseInt(vs[j])) {
                        Acoe = vs[i - 1];
                        AExp = vs[i];
                        vs[i - 1] = vs[j - 1];
                        vs[i] = vs[j];
                        vs[j - 1] = Acoe;
                        vs[j] = AExp;
                        Cambio=true;
                    }
                }
            }
        }
        System.out.println("\n");
        for (i = 0; i < vs.length; i++) {
            System.out.print("[" + vs[i] + "]");
        }
        System.out.println("\n");
        return vs;
    }
}
