/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author anahi
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
       EditorialServicio  editorialservicio = new EditorialServicio(); 
       AutorServicio autorservicio = new AutorServicio();
       LibroServicio libroservicio = new LibroServicio();
            //administra todas las operaciones que se van a ser con objetos en la base de datos. 
            //EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
            //EntityManager em = emf.createEntityManager();
        String resp; 
        int opc;
        do{    
         
        System.out.println("-------MENÚ--------");
        System.out.println("1.Crear libro");
        System.out.println("2.Crear Autor");
        System.out.println("3.Buscar Autor por nombre");
        System.out.println("4.Modificar Autor");
        System.out.println("5.Eliminar Autor");
        System.out.println("6.Crear editorial");
        System.out.println("7.Buscar editorial por nombre");
        System.out.println("8.Modificar editorial");
        System.out.println("9.Eliminar editorial");
        //System.out.println("10.Búsqueda de un Autor por nombre.");
        System.out.println("10.Búsqueda de un libro por ISBN.");
        System.out.println("11.Búsqueda de un libro por Título.");
        System.out.println("12.Búsqueda de un libro/s por nombre de Autor.");
        System.out.println("13.Búsqueda de un libro/s por nombre de Editorial.");
         
//Validar campos obligatorios.
//No ingresar datos duplicados.
        System.out.println("Ingrese otra opcion: ");
        opc = leer.nextInt(); 
         
        switch (opc){
            case 1: 
                libroservicio.CrearLibro();
                libroservicio.string();
                
                break;
            case 2: 
                autorservicio.crearAutor();
                break; 
            case 3: 
                autorservicio.ConsultarAutorPorNombre();
                break; 
            case 4: 
                autorservicio.ModificarAutor();
                break; 
            case 5: 
                autorservicio.EliminarAutor();
                break;    
            case 6: 
                editorialservicio.crearEditorial();
                break; 
            case 7: 
                editorialservicio.ConsultarEditorial();
                break;
            case 8: 
                editorialservicio.ModificarEditorial();
                break;    
            case 9: 
                editorialservicio.EliminarEditorial();
                break;    
            case 10: 
                libroservicio.busquedaLibroPorISBN();
                break;   
            case 11: 
                libroservicio.busquedaLibroPorTitulo();
                break;
            case 12: 
                libroservicio.busquedaLibroPorNombreAutor();
                break;
            case 13: 
                libroservicio.busquedaLibroPorNombreEditorial();
                break;    
            default:
                System.out.println("Opcion no identificada con calculos!");
                   break; 
        }
        System.out.println("Desea continuar S/N.");
        resp = leer.next();        
        }while(opc <= 13);
        
    }
    
}
