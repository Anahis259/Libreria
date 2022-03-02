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
 * 
 * @author anahi
 */
public class BarcosMotor extends Barcos{
    private int potenciaCV;

    public BarcosMotor() {
    }

    public BarcosMotor(int potenciaCV, String matricula, double esloraEnMetro, int añoDeFabricacion) {
        super(matricula, esloraEnMetro, añoDeFabricacion);
        assert(potenciaCV> 0); 
        this.potenciaCV = potenciaCV;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public void setPotenciaCV(int potenciaCV) {
        assert(potenciaCV> 0); 
        this.potenciaCV = potenciaCV;
    }
    public double getPrecioAlquiler(){
        return super.getPrecioAlquiler() +potenciaCV; 
    }
}
