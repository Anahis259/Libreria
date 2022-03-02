/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.servicio;

import agencia.Alquiler;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author anahi
 */
public class ServicioAlquiler {
    
    public void crearAlquiler(Alquiler alq) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        alq.setNombre(leer.next());
        System.out.println("Ingrese documento: ");
        alq.setDocumento(leer.next());
        System.out.println("Ingrese año de alquiler: ");
        alq.setFechaAlquiler(leer.nextInt());  
        System.out.println("Ingrese fecha de la devolucion: ");
        alq.setFechaAlquiler(leer.nextInt());
        System.out.println("Ingrese posicion de amarre: babor o estribo, proa o popa!");
        alq.setPosicionAmarre(leer.nextInt());
        
    }   

   

    
}
