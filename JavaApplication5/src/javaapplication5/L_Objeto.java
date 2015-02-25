/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.awt.image.BufferedImage;

/**
 *
 * @author Denis
 */
public class L_Objeto {
    public Nodo_Personaje raiz;
    public Nodo_Personaje crear_Objeto(String Nombre,int daño,int vida,String Clase,BufferedImage imagen){
        Nodo_Personaje a = new Nodo_Personaje(Nombre, daño, vida, Clase, imagen);
        return a;
    }//**/
    public void incertar_objeto(Nodo_Personaje Nuevo){
        if(raiz == null){
            raiz = Nuevo;
            //System.out.println("1er incertado");
        }else{
            Nodo_Personaje aux=raiz;
            while(aux.siguiente!=null){
                aux=aux.siguiente;
            }
            aux.siguiente = Nuevo;
            //System.out.println("incertado");
        }
    }
}
