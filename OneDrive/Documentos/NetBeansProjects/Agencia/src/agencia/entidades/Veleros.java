/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.entidades;


import agencia.Barcos;




/**
 *
 * @author anahi
 */
public  class Veleros extends Barcos{
    
    private int NroMastiles; 

    public Veleros() {
    }

    public Veleros(int NroMastiles,String matricula,double esloraEnMetro,int añoDeFabricacion) {
        super(matricula, esloraEnMetro, añoDeFabricacion);
        assert(this.NroMastiles > 0); 
        this.NroMastiles = NroMastiles;
    }

    public int getNroMastiles() {
        return NroMastiles;
    }

    public void setNroMastiles(int NroMastiles) {
        assert(this.NroMastiles > 0);
        this.NroMastiles = NroMastiles;
    }

    public double getPrecioAlquiler(){
        return super.getPrecioAlquiler()+getNroMastiles();
    
    }

    

   
            
}
