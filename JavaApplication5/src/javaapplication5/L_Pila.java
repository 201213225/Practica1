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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    public void generar() {
        try {

//path del dot.exe,por lo general es la misma, pero depende de donde hayas instalado el paquete de Graphviz
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";

//path del archivo creado con el codigo del graphviz que queremos
            String fileInputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\Pila.txt";

//path de salida del grafo, es decir el path de la imagen que vamos a crear con graphviz
            String fileOutputPath = "C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\Pila.jpg";

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
        String Pila="digraph g {\n" +
        "node [shape=record];\n" +
        "\n" +
        "subgraph cluster_3{\n" +
        "label= \"Pila de Zombis\"\n";
        Nodo_Pila aux = lista;
        while(aux.siguiente!=null){
            Pila=Pila+"\"Nombre: "+aux.zombi.Nombre+"\nPuntos: "+aux.zombi.vida+"\nDano: "+aux.zombi.daño+"\nClase: "+aux.zombi.Clase+"\"->";
            aux=aux.siguiente;
        }
        Pila=Pila+"\"Nombre: "+aux.zombi.Nombre+", Puntos: "+aux.zombi.vida+",\nDano: "+aux.zombi.daño+", Clase: "+aux.zombi.Clase+"\"";
        Pila=Pila+"}\n" +
        "\n" +
        "}";
        
        
        System.out.println(Pila);
        escribrifichero(Pila);
   }
     public void escribrifichero(String fichero) throws IOException{
       String rutarchivo ="C:\\Users\\Denis\\Documents\\NetBeansProjects\\reportes\\Pila.txt";
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


