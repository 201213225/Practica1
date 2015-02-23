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
public class Matriz {

    Nodo_Matriz Raiz;

    public void Generar_matriz(int x, int y) {
        int y1 = 0;
        
        Nodo_Matriz aux3=Raiz;
        while (y1 < y) {
            Nodo_Matriz aux1 = new Nodo_Matriz();
            Nodo_Matriz aux2 = aux1;
            int x1 = 0;
            while (x1 < x) {
                aux2.der = new Nodo_Matriz();
                aux2.x=x1;
                aux2.y=y1;
                aux2 = aux2.der;
                //System.out.println("x: "+x1+", y: "+y1);
                x1++;
                
                /*/aux2.x=x;
                 aux2.y=y;
                 x++;//*/
            }
            
            if(Raiz==null){
                Raiz=aux1;
                //System.out.println("incertado en raiz");
                aux3=Raiz;
            }else{
                aux3.ab=aux1;
                aux3=aux3.ab;
            }
            y1++;
        }
    }
}
