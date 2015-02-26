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
public class L_Pila {
    Nodo_Pila lista;
    public void incertar(Nodo_Personaje nuevo){
        if(lista==null){
            lista = new Nodo_Pila();
            lista.zombi = nuevo;
        }else{
            lista.anterior= new Nodo_Pila();
            lista.anterior.zombi=nuevo;
            lista.anterior.siguiente=lista;
            lista=lista.anterior;
        }
    }
    public void eliminar(){
        if(lista!=null){
            if(lista.siguiente==null){
                lista=null;
            }else{
                Nodo_Pila aux = lista;
                while(aux.siguiente!=null){
                    aux=aux.siguiente;
                }
                aux.anterior.siguiente=null;
            }
        }
    }
    public JLabel[] crearimagenes(int n_etiquetas){
        JLabel etiqueta[] = new JLabel[n_etiquetas];
        Nodo_Pila aux = lista;
        int i = 0;
        while(aux!=null){
            ImageIcon imagen = new ImageIcon(aux.zombi.imagen);
            etiqueta[i]=new JLabel("");
            etiqueta[i].setIcon(imagen);
            aux=aux.siguiente;
            i++;
        }
        return etiqueta;
    }
}
