/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;


/**
 *
 * @author anahi
 */
public class AutorServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Autor autor = new Autor();
    public void crearAutor() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese ID del autor: ");
        autor.setId(leer.nextInt());
        System.out.println("Ingrese nombre del autor: ");
        autor.setNombre(leer.next());
        System.out.println("Le damos el Alta? (True)");
        autor.setAlta(true);
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        //autor.setAlta(Alta);
        try {
            if (autor.getId() == null || autor.getId() == 0){
                 throw new Exception("Debe tener ID");      
        }
         if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
                throw new Exception("Debe un nombre");
            }    
                  
    } catch (Exception e){
        throw e; 
    }
    }
    
 public void ConsultarAutorPorNombre() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID del autor que desea buscar: ");
        int id = leer.nextInt();
        Autor autor = em.find(Autor.class, id);
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getResultList();
  
        try {
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }               
    } catch (Exception e){
        throw e; 
    }  
        if (autores.isEmpty()){
            System.out.println("Lista vacia");
        }
        for (Autor i : autores) {
            System.out.println(i);
     }
        
 }
    public void ModificarAutor() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID del autor que desea modificar:");
        Autor autor = em.find(Autor.class, leer.nextInt());
        System.out.println("Ingrese en nombre que desea asignarle: ");
        String nombre = leer.next().toUpperCase(); 
        autor.setNombre(nombre);
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        try {
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            if (autor.getNombre() == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre");
            }
    } catch (Exception e){
        throw e; 
    }  
        
    }
    public void EliminarAutor() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        System.out.println("Ingrese el ID del autor que desea eliminar:");
        
        Autor autor = em.find(Autor.class, leer.nextInt());
        //List<Autor> autores = em.createQuery("DELETE FROM Autor WHERE id =ID").setParameter("id", ID).getResultList();
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
        autor.setAlta(false);
        System.out.println("Eliminado correctamente! ");
        System.out.println("NO Eliminado ya que el autor esta siendo usado por un libro! ");
        try {
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            
    } catch (Exception e){
        throw e; 
    }  
    }
}
