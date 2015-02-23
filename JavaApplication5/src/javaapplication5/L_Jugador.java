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
public class L_Jugador {
    Nodo_Jugador raiz;
    public void agragar_jugador(String nombre,int cantidad){
        if(raiz==null){
            raiz = new Nodo_Jugador();
            raiz.cantidad=cantidad;
            raiz.nombre = nombre;
        }
    }
}
