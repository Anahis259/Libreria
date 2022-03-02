/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.time.Instant;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author anahi
 */
public class Alquiler {
    private String nombre;  
    private String documento; 
    private int fechaAlquiler;
    private int fechaDevolucion; 
    private int posicionAmarre; 
    private Barcos barco; 

    public Alquiler() {
    }

    public Alquiler(String nombre, String documento, int fechaAlquiler, int fechaDevolucion, int posicionAmarre, Barcos barco) {
        assert(nombre.length()> 0);  
        this.nombre = nombre;
        assert(documento.length()> 0);
        this.documento = documento;
        assert(fechaAlquiler> 0);
        this.fechaAlquiler = fechaAlquiler;
        assert(fechaDevolucion>fechaAlquiler);
        this.fechaDevolucion = fechaDevolucion;
        assert(posicionAmarre >= 0);
        this.posicionAmarre = posicionAmarre;
        assert( barco != null); 
        this.barco = barco;
    }
    
    
    public Barcos getBarco() {
        return barco;
    }

    public void setBarco(Barcos barco) {
        assert( barco != null);
        this.barco = barco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        assert(nombre.length()> 0);
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        assert(documento.length()> 0);
        this.documento = documento;
    }

    public int getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(int fechaAlquiler) {
        assert(fechaAlquiler>0 );
        this.fechaAlquiler = fechaAlquiler;
    }

    public int getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(int fechaDevolucion) {
        assert(fechaDevolucion>fechaAlquiler);
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(int posicionAmarre) {
        assert(posicionAmarre >= 0);
        this.posicionAmarre = posicionAmarre;
    }
    
    public int diasOcupacion(){
        return (int) (getFechaDevolucion()-getFechaAlquiler());
    }
    // los dias de ocupacion por el barco espeecifico por su precio de alquiler. aca lo instancio.
    public double getPrecioAlquiler(){
        return diasOcupacion()*getBarco().getPrecioAlquiler();
    }

    
}
