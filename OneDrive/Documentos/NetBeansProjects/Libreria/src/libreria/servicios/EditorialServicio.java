
package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;


public class EditorialServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public void crearEditorial() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        Editorial editorial = new Editorial(); 
        try {
        System.out.println("Ingrese ID de la editorial: ");
        editorial.setId(leer.nextInt());           
        System.out.println("Ingrese nombre de la editorial: ");
        editorial.setNombre(leer.next().toUpperCase());
        //System.out.println("Le damos el Alta? (True)");
        editorial.setAlta(true);
         if (editorial.getId() == null || editorial.getId() == 0){
                 throw new Exception("Debe tener ID");      
        }
         if (editorial.getNombre() == null || editorial.getNombre().trim().isEmpty()) {
                throw new Exception("Debe tener un nombre");
            }
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        } catch(Exception ex){
            System.out.println("los datos estan incompletos!Intentelo de nuevo  ");} 
    }
    public void ConsultarEditorial() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID de la editorial que desea consultar: ");
        int id = leer.nextInt();
        Editorial editorial = em.find(Editorial.class, id);
        List<Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a WHERE a.id LIKE :id").setParameter("id", id).getResultList();
        for (Editorial edi : editoriales) {
            System.out.println(edi);
        }
        
            if (editorial.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }               
     
      } catch (Exception e){
            System.out.println("El registro buscado no se encontro en la base de datos"); 
    }   
 }
    public void ModificarEditorial() throws Exception{
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID de la editorial que desea modificar:");
        Editorial editorial = em.find(Editorial.class,leer.nextInt() );        
        System.out.println("Ingrese en nombre que desea asignarle: ");
        String nombre = leer.next().toUpperCase(); 
        editorial.setNombre(nombre);
        em.getTransaction().begin();
        em.merge(editorial);//actualiza el registro
        em.getTransaction().commit();
        
            if (editorial.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            if (editorial.getNombre() == null || editorial.getNombre().trim().isEmpty()) {
                throw new Exception("Debe un nombre");
            }
    } catch (Exception e){
        System.out.println("El registro buscado no se encontro en la base de datos"); 
    }  
        
    }
    public void EliminarEditorial() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ID de la editorial que desea eliminar:");
        Editorial editorial = em.find(Editorial.class, leer.nextInt());
         if (editorial != null) {
             System.out.println("EDITORIAL " +editorial.getNombre() +" BORRADA EXITOSAMENTE");
         }else{
             System.out.println("EDITORIAL NO ENCONTRADA");
         }
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
        
            if (editorial.getId() == null){
                 throw new Exception("Debe tener ID registrado");      
        }    
            
    } catch (Exception e){
        System.out.println("No se puede eliminar porque no existe la editorial o esta siendo usada por otra entidad"); 
    }  
    }
   public void string(){
        Editorial editorial = new Editorial();
        editorial.toString();
    }
     
}
