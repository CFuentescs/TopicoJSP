package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.carga;
import modelo.infoD;
import modelo.infoE;

public class CargoDAO {

    private Connection connection;
    String total2 = "";
    int bono = 0;
    int bonoN = 0;

    public CargoDAO() throws ClassNotFoundException {
        connectionClass con = new connectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCargo(carga cargo) {
        System.out.println("agregando");
        try {
            String query = "insert into carga (rut_carga, nombre, fecha_nac,genero,rut_empleado,bono_escolar,bono_navidad) values ('" + cargo.getRut_carga() + "', '"
                    + cargo.getNombre() + "', '" + cargo.getFecha_nac() + "', '" + cargo.getGenero() + "',"
                    + "'" + cargo.getRut_empleado() + "','" + cargo.getBono_escolar() + "', '" + cargo.getBono_navidad() + "')";

            Statement stmt = connection.createStatement();
            System.out.println("agregando");
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String bono_por_Empleado(String rut) throws SQLException {

        ResultSet rs = null;
        System.out.println("hol");
        String total = "";

        String TotalF;

        String sql = "SELECT rut_empleado, SUM(bono_escolar+bono_navidad) "
                + "FROM carga "
                + "WHERE rut_empleado = '" + rut + "'"
                + "GROUP BY rut_empleado";

        Statement stmt = connection.createStatement();
        rs = stmt.executeQuery(sql);

        if (rs.next()) {
            total2 = rs.getString("SUM(bono_escolar+bono_navidad)");
            System.out.println(total2);
        }

        return total2;
    }

    public ArrayList<infoE> Bono_Gen() throws SQLException {

        String query = "SELECT carga.rut_empleado ,empleado.nombre,carga.nombre,carga.bono_escolar,carga.bono_navidad\n"
                + "                	FROM carga,empleado where carga.rut_empleado=empleado.rut_empleado ";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);

        ArrayList<infoE> informe = new ArrayList<>();
        
        while (res.next()) {

            infoE empl = new infoE();
            empl.setRut(res.getString("carga.rut_empleado"));
            empl.setNombre(res.getString("empleado.nombre"));
              System.out.println(empl.getNombre());
            empl.setNombre_carga(res.getString("carga.nombre"));
            empl.setTotalB(res.getString("carga.bono_escolar"));
            empl.setTotalN(res.getString("carga.bono_navidad"));
            informe.add(empl);
        }
        return informe;

    }

    public ArrayList<infoD> Bono_Dept() throws SQLException {

        String query = "SELECT empleado.nombre ,empleado.dpto,carga.nombre,carga.bono_escolar,carga.bono_navidad\n"
                + "                	FROM carga,empleado";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);

        ArrayList<infoD> informe = new ArrayList<>();

        while (res.next()) {

            infoD empl = new infoD();
            empl.setDepartamento(res.getString("empleado.dpto"));
            System.out.println(empl.getDepartamento());
            empl.setNombre(res.getString("empleado.nombre"));
            empl.setNombre_carga(res.getString("carga.nombre"));
            empl.setTotalB(res.getString("carga.bono_escolar"));
            empl.setTotalN(res.getString("carga.bono_navidad"));

            informe.add(empl);
        }
        return informe;

    }

    public ArrayList<infoD> Bono_Dept2(String dpto) throws SQLException {

        String query = "SELECT empleado.nombre ,empleado.dpto,carga.nombre,carga.bono_escolar,carga.bono_navidad "
                + "                	FROM carga,empleado "
                + "                WHERE empleado.dpto = '" + dpto + "'"
                + "and empleado.rut_empleado=carga.rut_empleado";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);

        ArrayList<infoD> informe = new ArrayList<>();

        while (res.next()) {

            infoD empl = new infoD();
            empl.setDepartamento(res.getString("empleado.dpto"));

            empl.setNombre(res.getString("empleado.nombre"));
            empl.setNombre_carga(res.getString("carga.nombre"));
            empl.setTotalB(res.getString("carga.bono_escolar"));
            empl.setTotalN(res.getString("carga.bono_navidad"));

            informe.add(empl);
        }
        return informe;

    }

    public String total(String tipo, String dpto) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet res;
        
        if (dpto == null && tipo.equals("departamento")) {

            String query = "SELECT empleado.dpto, SUM(carga.bono_escolar),SUM(carga.bono_navidad) "
                    + "	FROM carga,empleado"
                    + "	WHERE empleado.rut_empleado = carga.rut_empleado"
                    + "	group by empleado.dpto";

            res = stmt.executeQuery(query);
            while (res.next()) {

                bono = bono + Integer.parseInt(res.getString("SUM(carga.bono_escolar)"));
                bonoN = bonoN + Integer.parseInt(res.getString("SUM(carga.bono_navidad)"));

            }

        } else {

            String query = "SELECT empleado.dpto, SUM(carga.bono_escolar),SUM(carga.bono_navidad) "
                    + "	FROM carga,empleado"
                    + "	WHERE empleado.dpto = '" + dpto + "' and empleado.rut_empleado=carga.rut_empleado"
                    + "	group by empleado.dpto";

            res = stmt.executeQuery(query);
            while (res.next()) {

                bono = bono + Integer.parseInt(res.getString("SUM(carga.bono_escolar)"));
                bonoN = bonoN + Integer.parseInt(res.getString("SUM(carga.bono_navidad)"));

            }

        }

        if (tipo.equals("empleado") && null == dpto) {
            
            String query = "SELECT empleado.rut_empleado, SUM(carga.bono_escolar),SUM(carga.bono_navidad) "
                    + "	FROM carga,empleado"
                    + "	WHERE empleado.rut_empleado = carga.rut_empleado"
                    + "	group by empleado.rut_empleado";

            res = stmt.executeQuery(query);
            while (res.next()) {

                bono = bono + Integer.parseInt(res.getString("SUM(carga.bono_escolar)"));
                bonoN = bonoN + Integer.parseInt(res.getString("SUM(carga.bono_navidad)"));

            }

        }

        return "Total Bono Escolar:$ " + bono + "\n"
                + "Total Bono Navidad:$ " + bonoN + "";
    }


}
