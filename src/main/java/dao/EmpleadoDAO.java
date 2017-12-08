package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.empleado;

public class EmpleadoDAO {

    private Connection connection;

    public EmpleadoDAO() throws ClassNotFoundException {
        connectionClass con = new connectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmpleado(empleado empleado) {
        try {

            String query = "insert into empleado ( rut_empleado, nombre, Direccion, dpto, cargo, sbase) values ('" + empleado.getRut() + "', '" + empleado.getNombre() + "', '" + empleado.getDireccion() + "', '" + empleado.getDepartamento() + "','" + empleado.getCargo() + "','" + empleado.getSbase() + "')";

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
        }
    }

    public void removeEmpleado(String rut) {
        String query = "delete from empleado where empleado.rut_empleado = '" + rut + "' ";
        try {
            System.out.println(rut);
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmpleado(empleado empleado) {

        String query = "update empleado set empleado.nombre='" + empleado.getNombre() + "', empleado.direccion='" + empleado.getDireccion()
                + "', empleado.dpto='" + empleado.getDepartamento() + "', empleado.cargo='" + empleado.getCargo() + "', empleado.sbase='" + empleado.getSbase() + "' where empleado.rut_empleado= '" + empleado.getRut() + "' ";

        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<empleado> getEmpleados() throws SQLException {
        String query = "select * from empleado";

        ArrayList<empleado> empleados = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        System.out.println("hola2");
        while (res.next()) {

            empleado empl = new empleado();
            empl.setRut(res.getString("rut_empleado"));

            empl.setNombre(res.getString("nombre"));
            empl.setDireccion(res.getString("Direccion"));
            empl.setDepartamento(res.getString("dpto"));
            empl.setCargo(res.getString("cargo"));
            empl.setSbase(res.getString("sbase"));

            empleados.add(empl);
        }
        return empleados;
    }

    public ArrayList<empleado> getEmpleadobycargo(String cargo) throws SQLException {

        ArrayList<empleado> empleados = new ArrayList<>();

        String query = "select * from empleado where cargo='"+cargo+"'";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);

        while (res.next()) {
            empleado empl = new empleado();

            empl.setRut(res.getString("rut_empleado"));
            empl.setNombre(res.getString("nombre"));
            empl.setDireccion(res.getString("Direccion"));
            empl.setDepartamento(res.getString("dpto"));
            empl.setCargo(res.getString("cargo"));
            empl.setSbase(res.getString("sbase"));
            empleados.add(empl);
        }
        return empleados;
    }

    public ArrayList<empleado> getEmpleadobyDepartamento(String departamento) throws SQLException {
        ArrayList<empleado> empleados = new ArrayList<>();
        String query = "select * from empleado where empleado.dpto = '" + departamento + "' ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            empleado empl = new empleado();
            empl.setRut(res.getString("rut_empleado"));
            empl.setNombre(res.getString("nombre"));
            empl.setDireccion(res.getString("Direccion"));
            empl.setDepartamento(res.getString("dpto"));
            empl.setCargo(res.getString("cargo"));
            empl.setSbase(res.getString("sbase"));

            empleados.add(empl);
        }
        return empleados;
    }
}
