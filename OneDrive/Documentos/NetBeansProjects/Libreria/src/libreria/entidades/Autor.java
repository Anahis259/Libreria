/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author anahi
 */
@Entity
public class Autor  implements Serializable{
     @Id
    
    private Integer id; 
    private String nombre; 
    private boolean Alta; 

    public Autor() {
    }

    public Autor(Integer id, String nombre, boolean Alta) {
        this.id = id;
        this.nombre = nombre;
        this.Alta = Alta;
    }

    public Integer getId() {
        return id;
    }

    public boolean isAlta() {
        return Alta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setAlta(boolean Alta) {
        this.Alta = Alta;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", Alta=" + Alta + '}';
    }

    
    
    
    
}
