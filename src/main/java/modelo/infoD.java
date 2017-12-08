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
public class infoD {

    public infoD() {

    }
    public String departamento;
    public String nombre;
    public String nombre_carga;
    public String totalB;
    public String totalN;

    public void setNombre_carga(String nombre_carga) {
        this.nombre_carga = nombre_carga;
    }

    public String getNombre_carga() {
        return nombre_carga;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getTotalB() {
        return totalB;
    }

    public String getTotalN() {
        return totalN;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setTotalB(String totalB) {
        this.totalB = totalB;
    }

    public void setTotalN(String TotalN) {
        this.totalN = TotalN;
    }

}
