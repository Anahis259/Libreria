package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

public class LibroServicio {    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public void CrearLibro()throws Exception{
        try{
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            Libro libro = new Libro();
            System.out.println("Ingrese isbn del libro: ");
            libro.setIsbn(leer.nextInt());
            System.out.println("Ingrese titulo: ");
            libro.setTitulo(leer.next());
            System.out.println("Ingrese el año de culminacion: ");
            libro.setAnio(leer.nextInt());
            System.out.println("Ingrese el numero de ejemplares disponibles: ");
            libro.setEjemplares(leer.nextInt());
            System.out.println("Ingrese el numero de ejemplares prestados: ");
            libro.setEjemplaresPrestados(leer.nextInt());
            System.out.println("Ingrese el numero de ejemplares restantes: ");
            libro.setEjemplaresRestantes(leer.nextInt());
            System.out.println("Le damos el Alta? (True)");
            libro.setAlta(true);
            System.out.println("Ingrese el ID del autor: ");
            Autor a =  em.find(Autor.class, leer.nextInt());// encuentra el autor.
            libro.setAutor(a);
            System.out.println("Ingrese el ID del editorial: ");
            Editorial e = em.find(Editorial.class, leer.nextInt());// encuentra el autor.
            libro.setEditorial(e);
            System.out.println("Libro GUARDADO!");
            
            em.getTransaction().begin();
           
            em.persist(libro);
           
            em.getTransaction().commit();   
            
            if (libro.getIsbn() <= 0) {
                throw new Exception ("Debe tener un isbn");
            }
            if (libro.getTitulo() == null  || libro.getTitulo().trim().isEmpty()) {
                throw new Exception ("Debe tener un titulo");
            }
            if (libro.getAnio() < 1900 || libro.getAnio() > 2022) {
                throw new Exception ("Debe ser un año valido");
            }
            if (libro.getEjemplares() < 1) {
                throw new Exception ("Debe tener mas de un ejemplar");
            }
            if (libro.getEjemplaresPrestados() > libro.getEjemplares()) {
                throw new Exception ("Debe tener un numero valido de ejemplares prestados");
            }
            if (libro.getEjemplares()-(libro.getEjemplaresPrestados()) != libro.getEjemplaresRestantes()) {
                throw new Exception ("Ejemplares Restantes debe ser igual a ejemplares prestados menos ejemplares");
            }
            if (libro.getEditorial() == null) {
                throw new Exception ("Debe tener una editorial asignada");
            }
            if (libro.getAutor() == null) {
                throw new Exception ("Debe tener un autor asignado");
            }
           
        }catch (Exception e){ 
            System.out.println("Debe llenar todos los datos que se piden para agregar un libro!.");; 
        }
        
    }
    public void busquedaLibroPorISBN(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el ISBN del libro que desea buscar: "); 
        long isbn = leer.nextLong();
        Libro l = em.find(Libro.class, isbn);
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn").setParameter("isbn",isbn).getResultList();
        
        if (libros.isEmpty()){
            System.out.println("No se encuentra ese ISBN");
        }
        for (Libro lib : libros) {
            System.out.println(lib);
        }
        }catch (Exception e){ 
            System.out.println("No se encuentra el ISBN del libro consultado!.");; 
        }
    }
    
    public void busquedaLibroPorTitulo(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el titulo del libro que desea buscar: "); 
        String titulo = leer.next().toUpperCase();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo",titulo).getResultList();
        if (libros.isEmpty()){
            System.out.println("No se encuentra un libro con ese titulo");
        }
        for (Libro lib : libros) {
            System.out.println(lib);
        }
        }catch (Exception e){ 
            System.out.println("No se encuentra el TITULO del libro consultado!.");; 
        }
    }
    public void busquedaLibroPorNombreAutor(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el nombre de Autor del libro que desea buscar: ");
        String nombre = leer.next().toUpperCase();
        //Libro nomAutor = em.find(Libro.class, leer.next());
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :nombre").setParameter("nombre",nombre).getResultList();
        if (libros.isEmpty()){
            System.out.println("No se encuentra un libro con ese autor");
        }
        for (Libro lib : libros) {
            System.out.println(lib);
        }
        }catch (Exception e){ 
            System.out.println("No se encuentra el LIBRO con el nombre del AUTOR consultado!.");; 
        }
    }
    public void busquedaLibroPorNombreEditorial(){
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        try {
        System.out.println("Ingrese el nombre de editorial del libro que desea buscar: "); 
        String nomEditorial = leer.next().toUpperCase();
        
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :nomEditorial").setParameter("nomEditorial", nomEditorial).getResultList();
        if (libros.isEmpty()){
            System.out.println("No se encuentra un libro con esa editorial");
        }
        for (Libro lib : libros) {
            System.out.println(lib);
        }
        }catch (Exception e){ 
            System.out.println("No se encuentra el LIBRO con el nombre de la EDITORIAL consultado!.");; 
        }
    }
    public void string(){
        Libro libro = new Libro();
        libro.toString();
    }
    
}
