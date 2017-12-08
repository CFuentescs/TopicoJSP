<%-- 
    Document   : informe
    Created on : 20-10-2017, 12:50:07
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script>
            $(document).ready(function () {
                $('.dropdown a.test').on("click", function (e) {
                    $(this).next('ul').toggle();
                    e.stopPropagation();
                    e.preventDefault();
                });
            });
        </script>
        <style type=text/css media=screen>

            #headercontainer{
                background-color: #2c4959;

            }



            body {



                background-image: url(http://localhost:8080/Solemne2v2.0/images/logo_2.png) ;

                background-position: center center;


                background-repeat: no-repeat;


                background-attachment: fixed;


                background-size: 45%;

            }
        </style>
    </head>
    <body>
        <header>

            <div class="container-fluid">
                <div class="row">

                    <nav id="headercontainer" class="navbar navbar-inverse" >
                        <div id="headercontainer" class="container-fluid" style="    margin-bottom: 10px;" >
                            <div class="navbar-header">
                                <a class="navbar-brand" style=" padding-top: 5px;" href="menu.jsp">
                                    <img src="http://localhost:8080/Solemne2v2.0/images/logo_4.png" alt="Logo UNAB" style="height:50px ; width:50px ; margin-left: 25px ;  ; padding-bottom: 0px " >
                                </a>
                            </div>
                            <ul class="nav navbar-nav">
                                <li><a href="empleado.jsp" > <font size="3"> Empleado </font></a></li>
                                <li><a href="cargo.jsp"> <font size="3"> Cargo </font></a></li>

                                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> <font size="3">Informe </font><span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a tabindex="-1" href="Control_cargo?action=infoE">Bono general</a></li>
                                        <li>
                                            <a class="test" tabindex="-1" href="#">Informe por Departamento<span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a tabindex="-1" href="Control_cargo?action=infoD2&dpto=administracion">Informe por administración</a></li>
                                                <li><a tabindex="-1" href="Control_cargo?action=infoD2&dpto=logistica">Informe por Logistica</a></li>
                                                <li><a tabindex="-1" href="Control_cargo?action=infoD2&dpto=gestion">Informe por Gestion</a></li>
                                                <li><a tabindex="-1" href="Control_cargo?action=infoD">Informe Total</a></li>

                                            </ul>
                                        </li>
                                    </ul>
                            </ul>

                        </div>

                    </nav>
                </div>
            </div>       
        </header>
        <div class="container">
            <div class="col-lg-12 table-responsive">

                <h2>Total de bonos por Departamento</h2>

                <table class="table table-striped ">

                    <thead>
                        <tr>
                            <th class="success">Nombre del empleado</th>
                            <th class="success">Departamento</th>
                            <th class="success">Nombre de la carga</th>
                            <th class="success">Bono Escolar</th>
                            <th class="success">Bono Navidad</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="infoD" items="${info}">
                            <tr>
                                <td>
                                    <c:out value="${infoD.nombre}"/>
                                </td>
                                <td>
                                    <c:out value="${infoD.departamento}"/>
                                </td>
                                <td>
                                    <c:out value="${infoD.nombre_carga}"/>
                                </td>
                                <td>
                                    <c:out value="${infoD.totalB}"/>
                                </td>
                                <td>
                                    <c:out value="${infoD.totalN}"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>  
                ${total}
            </div> 
        </div>
    </body>

</html>
