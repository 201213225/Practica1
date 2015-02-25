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
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
 *
 * @author Luis
 */
public class CargarImagen {
     
    //Imagen actual que se ha cargado
    private BufferedImage imageActual;
     
    //Método que devuelve una imagen abierta desde archivo
    //Retorna un objeto BufferedImagen
    public BufferedImage abrirImagen(){
        //Creamos la variable que será devuelta (la creamos como null)
        BufferedImage bmp=null;
        //Creamos un nuevo cuadro de diálogo para seleccionar imagen
        JFileChooser selector=new JFileChooser();
        //Le damos un título
        selector.setDialogTitle("Seleccione una imagen");
        //Filtramos los tipos de archivos
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG & GIF & BMP", "jpg", "gif", "bmp");
        selector.setFileFilter(filtroImagen);
        //Abrimos el cuadro de diálog
        int flag=selector.showOpenDialog(null);
        //Comprobamos que pulse en aceptar
        if(flag==JFileChooser.APPROVE_OPTION){
            try {
                //Devuelve el fichero seleccionado
                File imagenSeleccionada=selector.getSelectedFile();
                //Asignamos a la variable bmp la imagen leida
                bmp = ImageIO.read(imagenSeleccionada);
            } catch (Exception e) {
            }
                  
        }
        //Asignamos la imagen cargada a la propiedad imageActual
        imageActual=bmp;
        //Retornamos el valor
        return bmp;
    }
}
