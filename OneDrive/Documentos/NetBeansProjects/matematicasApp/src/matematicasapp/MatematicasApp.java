/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicasapp;


import matematicasServicio.servicioMat;
import matematicasapp.entidades.matematicas;

/**
 *
 * @author anahi
 */
public class MatematicasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //declaramos una variable del tipo matematicas con nombre matematicasObj. 
       matematicas obj1 = new matematicas(); 
//       servicioMat.crearNumeros(obj1);
//       obj1.
//       obj1.setNumeroDos(0);
        servicioMat.crearNumeros(obj1);
        servicioMat.imprimir(obj1);
       
       
        /*Scanner leer = new Scanner(System.in);
        // de la clase servicio inicializo con un nombre cualquiera 
        servicioMat servicioMatemat = new servicioMat();
        matematicas matematicasObj;
        matematicasObj = servicioMatemat.crearNumeros(obj1);
        servicioMatemat.imprimir(matematicasObj);*/
    }
    
}
