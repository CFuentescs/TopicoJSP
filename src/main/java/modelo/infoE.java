/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carl
 */
public class infoE {
    
    public infoE (){

}
    public String rut;
    public String nombre;
    public String nombre_carga;
    public String TotalN;
    public String TotalB;

    public void setTotalN(String TotalN) {
        this.TotalN = TotalN;
    }

    public void setTotalB(String TotalB) {
        this.TotalB = TotalB;
    }

    public String getTotalN() {
        return TotalN;
    }

    public String getTotalB() {
        return TotalB;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre_carga(String nombre_carga) {
        this.nombre_carga = nombre_carga;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombre_carga() {
        return nombre_carga;
    }
    public String bonoCarga;
    public String bonoN;

    public String getRut() {
        return rut;
    }

    public String getBonoCarga() {
        return bonoCarga;
    }

    public String getBonoN() {
        return bonoN;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setBonoCarga(String bonoCarga) {
        this.bonoCarga = bonoCarga;
    }

    public void setBonoN(String bonoN) {
        this.bonoN = bonoN;
    }
    
}
