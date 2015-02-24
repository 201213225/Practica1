/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author Denis
 */
public class Nodo_Jugador {

    String tipo;
    Nodo_Jugador siguiente;
    Nodo_Texto texto;
    String nombre;
    int cantidad;

    public void agregar_texto(String texto) {
        if (this.texto == null) {
            this.texto = new Nodo_Texto();
            this.texto.texto = texto;
        } else {
            Nodo_Texto aux = this.texto;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = new Nodo_Texto();
            aux.siguiente.texto = texto;
        }

    }
}
