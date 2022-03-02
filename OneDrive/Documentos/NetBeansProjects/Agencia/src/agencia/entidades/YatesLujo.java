/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.entidades;

import agencia.Alquiler;
import agencia.Barcos;
import agencia.servicio.ServicioAlquiler;

/**
 *
 * @author anahi
 */
public class YatesLujo extends BarcosMotor{
     
    private int numeroCamarotes; 

    public YatesLujo() {
    }

    public YatesLujo(int numeroCamarotes, int potenciaCV, String matricula, double esloraEnMetro, int añoDeFabricacion) {
        super(potenciaCV, matricula, esloraEnMetro, añoDeFabricacion);
        assert (numeroCamarotes > 0);  
        this.numeroCamarotes = numeroCamarotes;
    }

    public void setNumeroCamarotes(int numeroCamarotes) {
        
        assert (numeroCamarotes > 0);  
        this.numeroCamarotes = numeroCamarotes;
    }
    public int getNumeroCamarotes() {
        return numeroCamarotes;
    }
    
    public double getPrecioAlquiler(){
        return super.getPrecioAlquiler()+ getNumeroCamarotes();
    }
    
    
    
}
