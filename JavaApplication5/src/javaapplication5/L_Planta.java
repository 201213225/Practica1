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
public class L_Planta {
    public Nodo_Planta raiz;
    public Nodo_Planta crear_Planta(String Nombre,int daño,int vida,String Clase){
        Nodo_Planta a = new Nodo_Planta(Nombre, daño, vida, Clase);
        return a;
    }//**/
    public void incertar_planta(Nodo_Planta Nuevo){
        if(raiz == null){
            raiz = Nuevo;
            System.out.println("1er incertado");
        }else{
            Nodo_Planta aux=raiz;
            while(aux.siguiente!=null){
                aux=aux.siguiente;
            }
            aux.siguiente = Nuevo;
            System.out.println("incertado");
        }
    }
}
