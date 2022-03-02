/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.util.Calendar;

/**
 *
 * @author anahi
 */
public abstract class Barcos {
    protected String matricula; 
    protected double esloraEnMetro;
    protected int añoDeFabricacion; 
    public int MULTIP_ESLORA = 10; 

    public Barcos() {
    }

    public Barcos(String matricula, double esloraEnMetro, int añoDeFabricacion) {
        assert (matricula.length()>0); 
        this.matricula = matricula;
        assert(this.esloraEnMetro > 0);
        this.esloraEnMetro = esloraEnMetro;
        assert(this.añoDeFabricacion > 0);
        this.añoDeFabricacion = añoDeFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        assert (matricula.length()>0);
        this.matricula = matricula;
    }

    public double getEsloraEnMetro() {
        return esloraEnMetro;
    }

    public void setEsloraEnMetro(double esloraEnMetro) {
        assert(this.esloraEnMetro > 0);
        this.esloraEnMetro = esloraEnMetro;
    }

    public int getAñoDeFabricacion() {
        return añoDeFabricacion;
    }

    public void setAñoDeFabricacion(int añoDeFabricacion) {
        assert (añoDeFabricacion <= Calendar.getInstance().get(Calendar.YEAR));
        this.añoDeFabricacion = añoDeFabricacion;
    }
            
    public double getPrecioAlquiler(){
        return MULTIP_ESLORA * getEsloraEnMetro()*12;
    } 
}
