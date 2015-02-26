/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Denis
 */
public class L_Cola {

    Nodo_Cola lista;
    
    public void incertar(Nodo_Personaje nuevo) {
        if (lista == null) {
            lista = new Nodo_Cola();
            lista.planta = nuevo;
        } else {
            Nodo_Cola aux;
            aux = lista;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = new Nodo_Cola();
            aux.siguiente.planta = nuevo;
            aux.siguiente.anterior = aux;
        }
    }
    /*public Nodo_Cola buscar(String nombre){
     if(lista!=null){
     Nodo_Cola aux=lista;
     while(aux!=null && aux.planta.Nombre!=nombre){
     aux=aux.siguiente;
     }
     return aux;
     }
     return null;
     }//*/

    public void eliminar() {
        if (lista != null) {
            if (lista.siguiente == null) {
                lista = null;
            } else {
                lista=lista.siguiente;
                lista.anterior=null;
            }
        }
    }
    public JLabel[] crearimagenes(int n_etiquetas){
        
        JLabel etiqueta[] = new JLabel [n_etiquetas];
        Nodo_Cola aux = lista;
        int i=0;
        while(aux!=null){
            //System.out.println(i);
            ImageIcon imagen = new ImageIcon(aux.planta.imagen);
            etiqueta[i]=new JLabel("");
            etiqueta[i].setIcon(imagen);
            aux = aux.siguiente;
            i++;
        }
        return etiqueta;
    }
}
