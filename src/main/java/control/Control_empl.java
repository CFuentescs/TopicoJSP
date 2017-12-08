/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.empleado;

/**
 *
 * @author carl
 */
@WebServlet(name = "PersonController", urlPatterns = {"/PersonController"})
public class Control_empl extends HttpServlet {

    private static long serialVersionUID = 1L;

    private EmpleadoDAO empleadodao;

    private static String edit_or_add = "/empleado.jsp";

    private static String menu = "/menu.jsp";

    empleado person = new empleado();

    public Control_empl() throws ClassNotFoundException {
        super();
        empleadodao = new EmpleadoDAO(); // instancia un objeto de la clase PersonDAO
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String forward = "";
        String rut;
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        String cargo2 = request.getParameter("cargo2");
        String dpto = request.getParameter("departamento");

        if ("Eliminar".equals(action)) {
            rut = request.getParameter("Run");

            
            empleadodao.removeEmpleado(rut);

            forward = edit_or_add;
            try {
                request.setAttribute("empleados", empleadodao.getEmpleados());
             
                
            } catch (SQLException ex) {
                Logger.getLogger(Control_empl.class.getName()).log(Level.SEVERE, null, ex);
            }
             response.sendRedirect(request.getContextPath() + "/empleado.jsp");
        } else {

            if ("Listar".equals(action)) {

                forward = edit_or_add;
                empleado mol = new empleado();
              
                try {

                    ArrayList<empleado> emp = empleadodao.getEmpleados();
                    request.setAttribute("empleados", emp);
                    if (cargo2.equals(" ")&&dpto==null) {

                        request.setAttribute("empleados", emp);
                    } else {

                        if (cargo2.equals("basica")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobycargo(cargo2));
                        }
                        if (cargo2.equals("media")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobycargo(cargo2));
                        }
                        if (cargo2.equals("superior")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobycargo(cargo2));
                        }
                    }

                    if (dpto.equals(" ")&&cargo2==null) {

                        request.setAttribute("empleados", emp);
                    } else {

                        if (dpto.equals("administracion")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobyDepartamento(dpto));
                        }
                        if (dpto.equals("logistica")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobyDepartamento(dpto));
                        }
                        if (dpto.equals("gestion")) {

                            request.setAttribute("empleados", empleadodao.getEmpleadobyDepartamento(dpto));
                        }
                    }
                    
                 

                } catch (SQLException e) {
                    throw new ServletException("Cannot obtain products from DB", e);
                }
                
                
                
                RequestDispatcher view = request.getRequestDispatcher(forward);
                view.forward(request, response);
                
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        empleado persons = new empleado();

        persons.setRut(request.getParameter("rut"));
        persons.setNombre(request.getParameter("nombre"));
        persons.setDireccion(request.getParameter("direccion"));
        persons.setDepartamento(request.getParameter("departamento"));
        persons.setCargo(request.getParameter("cargo"));
        persons.setSbase(request.getParameter("Sbase"));
        String personid = request.getParameter("rut");
        String action = request.getParameter("enviar");

        if ("actualizar".equals(action)) {

            empleadodao.updateEmpleado(persons);

        } else {

            empleadodao.addEmpleado(persons);
        }

        response.sendRedirect(request.getContextPath() + "/empleado.jsp"); // vuelve al index

    }
}
