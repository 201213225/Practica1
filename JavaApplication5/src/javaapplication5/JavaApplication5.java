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
public  class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static Matriz tablero;
    public static L_Jugador jugadores;
    public static Menu prueba;
    public static L_Objeto Plantas;
    public static L_Objeto Zombi;
    public static L_Cola ColaPlanta;
    public static L_Pila PilaZombi;
    public static void main(String[] args) {
        jugadores = new L_Jugador();
        tablero = new Matriz();
        Plantas = new L_Objeto();
        Zombi = new L_Objeto();
        ColaPlanta = new L_Cola();
        PilaZombi = new L_Pila();
        //tablero.Generar_matriz(5, 5);
        //System.out.println("x: "+tablero.Raiz.ab.ab.der.x+", y: "+tablero.Raiz.ab.ab.der.y);
        prueba = new Menu();
        
        prueba.show();
        //prueba.setResizable(false);
        
    }
    
}
