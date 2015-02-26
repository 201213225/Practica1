/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

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
        Reportes boton = new Reportes();
        boton.setVisible(true);
        prueba = new Menu();
        
        prueba.show();
        //prueba.setResizable(false);
        
    }
    static void generar() {
        try {

//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

//path del archivo creado con el codigo del graphviz que queremos
            String fileInputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\catalogo.txt";

//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String fileOutputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\catalogo.jpg";

//tipo de imagen de salida, en este caso es jpg
            String tParam = "-Tjpg";

            String tOParam = "-o";

//concatenamos nuestras direcciones. Lo que hice es crear un vector, para poder editar las direcciones de entrada y salida, usando las variables antes inicializadas
//recordemos el comando en la consola de windows: C:\Archivos de programa\Graphviz 2.21\bin\dot.exe -Tjpg grafo1.txt -o grafo1.jpg Esto es lo que concatenamos en el vector siguiente:
            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileInputPath;
            cmd[3] = tOParam;
            cmd[4] = fileOutputPath;

//Invocamos nuestra clase 
            Runtime rt = Runtime.getRuntime();

            rt.exec(cmd);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error eeeeee", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
        }
    }
    static void escribir() throws IOException{
        String Catalogo="digraph g {\n" +
        "node [shape=record];\n" +
        "\n" +
        "subgraph cluster_3{\n" +
        "label= \"Plantas\"\n";
        Nodo_Personaje aux = JavaApplication5.Plantas.raiz;
        while(aux.siguiente!=null){
            Catalogo=Catalogo+"\"Nombre: "+aux.Nombre+", Puntos: "+aux.vida+",\nDano: "+aux.daño+", Clase: "+aux.Clase+"\"->";
            aux=aux.siguiente;
        }
        Catalogo=Catalogo+"\"Nombre: "+aux.Nombre+", Puntos: "+aux.vida+",\nDano: "+aux.daño+", Clase: "+aux.Clase+"\"";
        
        
        Catalogo=Catalogo+"}\n" +
        "subgraph cluster_2{\n" +
        "label= \"Zombis\"\n";
        aux = JavaApplication5.Zombi.raiz;
        while(aux.siguiente!=null){
            Catalogo=Catalogo+"\"Nombre: "+aux.Nombre+", Puntos: "+aux.vida+",\nDano: "+aux.daño+", Clase: "+aux.Clase+"\"->";
            aux=aux.siguiente;
        }
        Catalogo=Catalogo+"\"Nombre: "+aux.Nombre+", Puntos: "+aux.vida+",\nDano: "+aux.daño+", Clase: "+aux.Clase+"\"}\n" +
        "\n" +
        "}";
        
        
        System.out.println(Catalogo);
        escribrifichero(Catalogo);
   }
     static void escribrifichero(String fichero) throws IOException{
       String rutarchivo ="C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\catalogo.txt";
        File archivo = new File(rutarchivo);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(fichero);
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(fichero);
        }
        bw.close();
        generar();
   }
    
}
