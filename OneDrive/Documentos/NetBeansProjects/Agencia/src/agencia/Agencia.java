/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import agencia.entidades.BarcosMotor;
import agencia.entidades.Veleros;
import agencia.entidades.YatesLujo;
import agencia.servicio.ServicioAlquiler;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author anahi
 */
public class Agencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
      Scanner leer = new Scanner(System.in); 
      ServicioAlquiler alquiler = new ServicioAlquiler();  
      Alquiler alq = new Alquiler();
      alquiler.crearAlquiler(alq);
      int opcion; 
      do{
      System.out.println("Indique el barco a alquilar. 1. Velero, 2. Barco a motor, 3. Yate de lujo!");
        opcion = leer.nextInt();
        }while(opcion != 1 && opcion != 2 && opcion != 3 );
        switch (opcion){
        case 1: 
            Barcos velero = new Veleros(4, "92ABC4", 90.5, 1994); 
            System.out.println("El precio del alquiler del velero es"+velero.getPrecioAlquiler());
            break; 
        case 2: 
            Barcos barcoMotor = new BarcosMotor(10, "574ABC54", 43.7, 1996);
            System.out.println("El precio del alquiler del barco motor es: "+barcoMotor.getPrecioAlquiler());
            break; 
        case 3: 
            BarcosMotor yate = new YatesLujo(3, 16, "967ACV6", 54.9, 1991); 
            System.out.println("El precio del alquiler del yate es: "+yate.getPrecioAlquiler());
            break; 
        default: 
            System.out.println("El valor ingresado no corresponde a valor establecido. ");
            break; 
    }
           
    }
    
}
