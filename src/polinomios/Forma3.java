/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author andres y felipene
 */
public class Forma3 {

    private Nodo punta;

    public Forma3() {
        this.punta = null;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void setPunta(Nodo punta) {
        this.punta = punta;
    }

    public void LlenarPoliF3(String[] Vs) {
        //recorrer nodos
        for (int i = 0; i < Vs.length - 1; i += 2) {
            if (Vs[i] == null) {
                continue;
            }
            //condiciones como x este sola o tenga un numero
            String sExp;

            if (Vs[i + 1] == null) {
                sExp = "1";         // Si esta vacío pongale un 1
            } else {
                sExp = Vs[i + 1];   // Si tiene algo dejele lo que tiene
            }
            String sCoef = Vs[i];
            //"arreglar" cosas como los espacios en vacio de los exponentes y coeficientes cuando son 1
            if (sCoef.equals("") || sCoef.equals("+")) {
                sCoef = "1";
            } else if (sCoef.equals("-")) {
                sCoef = "-";
            }
            //para el exponent
            if (sExp.equals("1")) {
                sExp = "";
            }
            try {
                int coe = Integer.parseInt(sCoef);
                int exp = Integer.parseInt(sExp);
                this.InsertarFinal(coe, exp);

            } catch (NumberFormatException e) {
            }//evito la basura
        }
    }

    public void InsertarFinal(int coe, int exp) {
        Nodo p = punta, x = new Nodo(coe, exp);
        if (punta == null) {
            punta = x;
        } else {
            while (p.getLiga() != null) {
                p = p.getLiga();
            }
            p.setLiga(x);
        }
    }

    public void MostrarForma3() {
        if (punta == null) {
            System.out.println("\nLista Vacia \n");
        } else {
            System.out.println("La punta es: ");
            Nodo p = punta;
            while (p != null) {
                System.out.print("[" + p.getCoe() + ", " + p.getExp() + "] -> ");
                p = p.getLiga();

            }
            System.out.println(" ");
        }
    }

    public void InsertarF3(int coe, int exp) {
        if (coe == 0) {
            return; 
        }
        //condicion que sea null o que el exponente sea mayor por el orden
        if (punta == null || exp > punta.getExp()) {
            Nodo nuevo = new Nodo(coe, exp);
            nuevo.setLiga(punta);
            punta = nuevo;
            return;
        }

        Nodo p = punta;
        Nodo q= null;

        //BUsco la posicion donde debe de ir el nodo segun el orden
        while (p != null && p.getExp() > exp) {
            q = p;
            p = p.getLiga();
        }

        if (p != null && p.getExp() == exp) {
            int suma = p.getCoe() + coe;
            p.setCoe(suma);

            //Si suman y da 0 lo elimino
            if (p.getCoe() == 0) {
                if (q == null) {
                    punta = punta.getLiga(); // Borramos la punta
                } else {
                    q.setLiga(p.getLiga()); // Borramos en el medio/final pasandole la liga al anterior y dejando que se pierda el nodo que quedo con coeficiente 0
                }
            }
        } //insertar al medio o al final
        else {
            Nodo nuevo = new Nodo(coe, exp);
            q.setLiga(nuevo);
            nuevo.setLiga(p);
        }
    }

 public void EliminarF3(int exp) {
        if (punta == null) {
            System.out.println("El polinomio ya está vacío.");
            return;
        }

        Nodo p = punta;
        Nodo q = null;

        //Busco el exponente
        while (p != null && p.getExp() != exp) {
            q = p;
            p = p.getLiga();
        }

        //ver si esta el exponente
        if (p == null) {
            System.out.println("Oe, el exponente " + exp + " no existe en este polinomio.");
            return;
        }
        //Ver donde estaba el exponente
        if (q == null) {
            punta = p.getLiga(); //elimino el primero
        } 
  
        else {
            q.setLiga(p.getLiga()); //la liga va al anterior perdiendose al nodo de adelante
        }
        
        System.out.println("Término con exponente " + exp + " eliminado melo.");
    }
    public String ReconstruirPoliF3() {
        if (punta == null) {
            System.out.println("\nLista Vacia \n");
        }
        Nodo p = punta;
        String resultado = "";
        boolean esPrimerTermino = true;
        while (p != null) {
            int exp = p.getExp();
            int coe = p.getCoe();
            if (coe != 0) {
                if (esPrimerTermino) {
                    if (coe < 0) {
                        resultado += "-";
                    }
                } else {
                    if (coe > 0) {
                        resultado += " + ";
                    } else {
                        resultado += " - ";
                    }
                }
                int valor = coe;
                if (valor < 0) {
                    valor = -valor;
                }
                if (valor != 1 || exp == 0) {
                    resultado += valor;
                }
                if (exp > 0) {
                    resultado += "x";
                }
                if (exp > 1) {
                    resultado += "^" + exp;
                }
                esPrimerTermino = false;
            }
            p = p.getLiga();
        }

        System.out.println(resultado);

        if (resultado.equals("")) {
            return "0";
        }
        return resultado;
    }
}
