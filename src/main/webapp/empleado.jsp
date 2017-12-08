<%-- 
   Document   : empleado
   Created on : 20-10-2017, 12:50:14
   Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Solemne 2</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

        <div class="container ">
            <div class=" col-lg-4">
                <form name="form" method="post" action="Control_empl">



                    <h3>Agregar Empleador</h3>                   
                    <div class="form-group ">
                        <label for="rut">Rut:</label>
                        <input type="text" class="form-control" name="rut">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" name="nombre">
                    </div>
                    <div class="form-group">
                        <label for="direccion">Direccion:</label>
                        <input type="text" class="form-control" name="direccion">
                    </div>
                    <div class="form-group">
                        <label for="departamento">Departamento</label>
                        <div>
                            <select class="form-control" name="departamento">
                                <option value="">Eliga un departamento</option>
                                <option value="gestion">Gestion</option>
                                <option value="logistica">Logistica</option>
                                <option value="administracion">Administración</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="carga">Bono</label>
                        <div>
                            <select class="form-control" name="cargo">
                                <option value="">Eliga un Bono</option>
                                <option value="basica">Basica</option>
                                <option value="media">Media</option>
                                <option value="superior">Superior</option>
                            </select>
                        </div>
                    </div>          
                    <div class="form-group">
                        <label for="Sbase">Sueldo Base:</label>
                        <input type="text" class="form-control" name="Sbase">
                    </div>

                    <button type="submit" class="btn btn-primary btn-block " name="enviar" value="enviar"> 
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Agregar</button>
                    <button type="submit" class="btn btn-primary btn-block" name="enviar" value="actualizar" >
                        <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>  Actualizar</button>


                </form>

            </div>





    <div class="col-lg-7">
        <form method="get" action="Control_empl">
            <h2>Lista de empleados</h2>

            <table class="table table-striped">

                <thead>
                    <tr>
                        <th class="success">Rut</th>
                        <th class="success">Nombre</th>
                        <th class="success">Direccion</th>
                        <th class="success">Departamento</th>
                        <th class="success">Cargo familiar</th>
                        <th class="success">Sueldo Base</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="empleado" items="${empleados}">
                        <tr>
                            <td>
                                <c:out value="${empleado.rut}"/>
                            </td>
                            <td>
                                <c:out value="${empleado.nombre}"/>
                            </td>
                            <td>
                                <c:out value="${empleado.direccion}"/>
                            </td>
                            <td>
                                <c:out value="${empleado.departamento}"/>
                            </td>
                            <td>
                                <c:out value="${empleado.cargo}"/>
                            </td>
                            <td>
                                <c:out value="${empleado.sbase}"/>
                            </td>

                            <td><a href="Control_empl?action=Eliminar&Run=<c:out value="${empleado.rut}"/>">Eliminar</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>  
            <div class="form-group">
                <label for="carga"> Buscar por Bono</label>
                <div>
                    <select class="form-control" name="cargo2">
                        <option value="">Eliga un Bono</option>
                        <option value="basica">Basica</option>
                        <option value="media">Media</option>
                        <option value="superior">Superior</option>
                    </select>
                </div>
            </div> 
            <div class="form-group">
                <label for="carga"> Buscar por departamento</label>
                <div>
                    <select class="form-control" name="departamento">
                        <option value="">Eliga un Departamento</option>
                        <option value="administracion">administrativo</option>
                        <option value="logistica">Logistica</option>
                        <option value="gestion">Gestion</option>
                    </select>
                </div>
            </div>  
            <button type="submit" class="btn btn-primary btn-block  " name="action" value="Listar" >
               <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> Listar  
            </button>
        </form>   
    </div>
</div>
</body>
</html>