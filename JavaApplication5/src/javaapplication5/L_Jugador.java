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
public class L_Jugador {

    Nodo_Jugador raiz;

    public void agregar_jugador(String nombre, int cantidad, String clase) {
        if (raiz == null) {
            raiz = new Nodo_Jugador();
            raiz.tipo = clase;
            raiz.cantidad = cantidad;
            raiz.nombre = nombre;
        } else {
            raiz.siguiente = new Nodo_Jugador();
            raiz.siguiente.tipo = clase;
            raiz.siguiente.cantidad = cantidad;
            raiz.siguiente.nombre = nombre;
        }
    }



    public void generar() {
        try {

//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

//path del archivo creado con el codigo del graphviz que queremos
            String fileInputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\jugadores.txt";

//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String fileOutputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\jugadores.jpg";

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
    public void escribir() throws IOException{
        String Jugadores="digraph g {\n" +
        "node [shape=record];\n" +
        "subgraph cluster_1{\n" +
        "struct1[label=\"jugador1: "+raiz.nombre+", cantidad: "+raiz.cantidad+", \ntipo: "+raiz.tipo+"\";]\n" +
        "struct2[label=\"jugador2: "+raiz.siguiente.nombre+", cantidad: "+raiz.siguiente.cantidad+", \ntipo: "+raiz.siguiente.tipo+"\";]\n" +
        "struct1->struct2\n" +
        "}\n" +
        "subgraph cluster_3{\n"+
        "struct1";
        Nodo_Texto aux=raiz.texto;
        while(aux!=null){
            Jugadores=Jugadores+"->"+"\""+aux.texto+"\"";
            aux=aux.siguiente;
        }
        Jugadores = Jugadores+";\n" +
                    "}\n" +
                    "subgraph cluster_2{\n"+
                    "struct2";
        aux=raiz.siguiente.texto;
        while(aux!=null){
            Jugadores=Jugadores+"->"+"\""+aux.texto+"\"";
            aux=aux.siguiente;
        }
        Jugadores=Jugadores+
        "}\n" +
        "}";
        System.out.println(Jugadores);
        escribrifichero(Jugadores);
   }
     public void escribrifichero(String fichero) throws IOException{
       String rutarchivo ="C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\jugadores.txt";
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
