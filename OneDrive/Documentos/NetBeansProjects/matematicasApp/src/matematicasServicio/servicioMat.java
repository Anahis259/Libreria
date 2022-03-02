/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matematicasServicio;

import java.util.Scanner;
import matematicasapp.entidades.matematicas;

/**
 *
 * @author anahi
 */
public class servicioMat {
    public static matematicas crearNumeros(matematicas obj1){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el rango inicial:");
        int inicial = leer.nextInt();
        System.out.println("Ingrese el rango final:");
        int end = leer.nextInt();
        
//        Random aleatorio = new Random();        
        obj1.setNumeroUno(((int) (Math.random()*end - inicial)));
        obj1.setNumeroDos(((int) (Math.random()*end - inicial)));
//        obj1.setNumeroUno(aleatorio.nextInt(end - inicial +1)- inicial);
//        obj1.setNumeroDos(aleatorio.nextInt(end - inicial +1)- inicial);
        return obj1;
    }

   public static  int devolverMayor(matematicas obj1){
     int mayor = Math.max(obj1.getNumeroUno(),obj1.getNumeroDos());
     return mayor;
    }
    public static double calcularPotencia(matematicas obj1){
        double potencia = Math.abs(Math.pow((Math.max(obj1.getNumeroUno(), obj1.getNumeroDos())), (Math.min(obj1.numeroUno, obj1.numeroDos)))) ;
        return potencia;
    }
    public static double calcularRaiz(matematicas obj1){
        double raizUno = Math.abs(Math.sqrt(obj1.getNumeroUno()));
        double raizDos = Math.abs(Math.sqrt(obj1.getNumeroDos()));
        return raizUno + raizDos;
    }

    public static void imprimir(matematicas obj1){
        System.out.println("El numero uno es: "+obj1.getNumeroUno());
        System.out.println("El numero dos es: "+obj1.getNumeroDos());
        System.out.println("El mayor de ambos numero es: " + devolverMayor(obj1) );
        System.out.println("La potencia de ambos numero es: "+ calcularPotencia(obj1));
        System.out.println("La raiz de ambos numero es: " +calcularRaiz(obj1));
    }
}
