/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.awt.image.BufferedImage;
import java.util.Random;

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
            aux.siguiente.anterior = aux;
            //System.out.println("incertado");
        }
    }
    public Nodo_Personaje buscarRandom(){
        int i=0;
        Nodo_Personaje aux = raiz;
        while(aux!=null){
            aux=aux.siguiente;
            i++;
        }
        //System.out.println("el largo es: "+i);
        aux = raiz;
        Random generator = new Random();
        int j= generator.nextInt(i)+1;
        //System.out.println("el random fue es: "+j);
        i=1;
        aux=raiz;
        while(i<j){
            aux=aux.siguiente;
            i++;
        }
        System.out.println(aux.Nombre);
        return aux;
    }
}
