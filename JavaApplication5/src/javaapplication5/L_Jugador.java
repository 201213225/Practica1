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
    public void agregar_jugador(String nombre,int cantidad, String clase){
        if(raiz==null){
            raiz = new Nodo_Jugador();
            raiz.tipo = clase;
            raiz.cantidad=cantidad;
            raiz.nombre = nombre;
        }else{
            raiz.siguiente = new Nodo_Jugador();
            raiz.siguiente.tipo = clase;
            raiz.siguiente.cantidad=cantidad;
            raiz.siguiente.nombre = nombre;
        }
        graphviz();
    }

    public void graphviz() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
