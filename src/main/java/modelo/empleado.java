/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class empleado {

    public empleado() {

    }

    public String rut;
    public String nombre;
    public String direccion;
    public String departamento;
    public String cargo;
    public String sbase;

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSbase() {
        return sbase;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSbase(String sbase) {
        this.sbase = sbase;
    }

    
   
}