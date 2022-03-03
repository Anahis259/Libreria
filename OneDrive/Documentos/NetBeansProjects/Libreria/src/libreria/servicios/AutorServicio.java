
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

public class AutorServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Autor autor = new Autor();
    public void crearAutor() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
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
        
            if (autor.getId() == null || autor.getId() == 0){
                 throw new Exception("Debe tener ID");      
        }
         if (autor.getNombre() == null || autor.getNombre().trim().isEmpty()) {
                throw new Exception("Debe un nombre");
            }    
                  
    } catch (Exception e){
            System.out.println("Algun dato ingresado no corresponde a un ID o NOMBRE");
    }
    }
    
 public void ConsultarAutorPorId() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID del autor que desea buscar: ");
        int id = leer.nextInt();
        Autor autor = em.find(Autor.class, id);
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.id LIKE :id").setParameter("id", id).getResultList();
  
        
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }               
      
        if (autores.isEmpty()){
            System.out.println("Lista vacia");
        }
        for (Autor i : autores) {
            System.out.println(i);
     }
     } catch (Exception e){
            System.out.println("El ID ingresado no se encuentra en la base de datos"); 
    }   
 }
    public void ModificarAutor() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID del autor que desea modificar:");
        Autor autor = em.find(Autor.class, leer.nextInt());
        System.out.println("Ingrese en nombre que desea asignarle: ");
        String nombre = leer.next().toUpperCase(); 
        autor.setNombre(nombre);
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            if (autor.getNombre() == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe un nombre");
            }
    } catch (Exception e){
            System.out.println("El ID ingresado debe estar registrado en la base de datos.");; 
    }  
        
    }
    public void EliminarAutor() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID del autor que desea eliminar:");
        Autor autor = em.find(Autor.class, leer.nextInt());
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
        autor.setAlta(false);
        System.out.println("Eliminado correctamente! ");
        System.out.println("NO Eliminado ya que el autor esta siendo usado por un libro! ");
        
            if (autor.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            
    } catch (Exception e){
            System.out.println("El ID del autor buscado debe estar registrado y no estar vinculado a otra entidad");; 
    }  
    }
}
