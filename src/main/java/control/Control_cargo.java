/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import com.itextpdf.text.DocumentException;
import dao.CargoDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.carga;

/**
 *
 * @author carl
 */
public class Control_cargo extends HttpServlet {

    private final CargoDAO cargodao;
    private static String car = "/cargo.jsp";
    private static String info = "/informe.jsp";
    private static String menu = "/menu.jsp";
    private static String info2 = "/informeBono.jsp";
    carga cargas = new carga();

    public Control_cargo() throws ClassNotFoundException {
        super();
        cargodao = new CargoDAO(); // instancia un objeto de la clase PersonDAO
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileNotFoundException {
        System.out.println("intentando ingresar");
        String forward = "";
        String rut;
        PrintWriter out = response.getWriter();
        rut = request.getParameter("rut2");
        String dpto = request.getParameter("dpto");

        String action = request.getParameter("action");

        System.out.println(action);
        System.out.println(dpto);

        if (action.equals("enviar")) {

            try {

                request.setAttribute("cargo", cargodao.bono_por_Empleado(rut));
            } catch (SQLException ex) {
                Logger.getLogger(Control_cargo.class.getName()).log(Level.SEVERE, null, ex);
            }
            forward = car;
        } else {

            if (action.equals("infoD")) {

                try {
                    
                    request.setAttribute("info", cargodao.Bono_Dept());
                    request.setAttribute("total", cargodao.total("departamento", null));

                } catch (SQLException ex) {
                    Logger.getLogger(Control_cargo.class.getName()).log(Level.SEVERE, null, ex);
                }

                forward = info;
            } else {
                if (action.equals("infoD2")) {

                    try {
                        request.setAttribute("info", cargodao.Bono_Dept2(dpto));
                        request.setAttribute("total", cargodao.total("departamento", dpto));
                    } catch (SQLException ex) {
                        Logger.getLogger(Control_cargo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    forward = info;
                } else {
                    
                    if (action.equals("infoE")) {
                        
                        System.out.println("holi estoy entrando");
                        try {
                            request.setAttribute("info2", cargodao.Bono_Gen());
                            request.setAttribute("total", cargodao.total("empleado", null));
                            System.out.println("holi estoy saliendo");
                        } catch (SQLException ex) {
                            Logger.getLogger(Control_cargo.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        forward = info2;
                    }

                }

            }
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("hola");
        carga cargos = new carga();

        cargos.setRut_carga(request.getParameter("rut"));
        cargos.setNombre(request.getParameter("nombre"));
        cargos.setFecha_nac(request.getParameter("fecha"));
        cargos.setGenero(request.getParameter("genero"));
        cargos.setRut_empleado(request.getParameter("rutT"));
        cargos.setBono_escolar(request.getParameter("bono"));
        cargos.setBono_navidad(request.getParameter("bonoV"));
        String action = request.getParameter("enviar");

        System.out.println("agregando");
        cargodao.addCargo(cargos);
        System.out.println("agregando");

        response.sendRedirect(request.getContextPath() + car);
    }
}

/**
 * Returns a short description of the servlet.
 *
 * @return a String containing servlet description
 */
