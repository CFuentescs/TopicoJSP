<%-- 
    Document   : cargo
    Created on : 23-10-2017, 13:59:05
    Author     : carl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cargo</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.1/themes/base/jquery-ui.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.1/jquery-ui.js"></script>

<script>
    $(document).ready(function () {
        $('.dropdown a.test').on("click", function (e) {
            $(this).next('ul').toggle();
            e.stopPropagation();
            e.preventDefault();
        });
    });
</script>
<script>
    $(function () {
        $("#fecha").datepicker();
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


        <form name="form" method="post" action="Control_cargo">

            <div class=" col-lg-4">
                <h3>Agregar Carga</h3>                   
                <div class="form-group ">
                    <label for="rut de la Persona">Rut:</label>
                    <input type="text" class="form-control" name="rut">
                </div>
                <div class="form-group">
                    <label for="nombre de la Persona">Nombre:</label>
                    <input type="text" class="form-control" name="nombre">
                </div>

                <div class="form-group">
                    <label for="fecha">Fecha de nacimiento:</label>
                    <input type="text" class="form-control" id="fecha" name="fecha" value="">
                </div>

                <div class="form-group">
                    <label for="genero">Genero: </label>
                    <div>
                        <select class="form-control" name="genero">
                            <option value="">Eliga un Tipo de Genero</option>
                            <option value="masculino">Masculino</option>
                            <option value="femenino">Femenino</option>
                            <option value="otro">Otros...</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="rutT">Rut del Trabajador:</label>
                    <input type="text" class="form-control" name="rutT">
                </div>
                <div class="form-group">
                    <label for="Bon">Bono:</label>
                    <div>
                        <select class="form-control" name="bono">
                            <option value=0>Eliga un Bono</option>
                            <option value="20000">Basica</option>
                            <option value="40000">Media</option>
                            <option value="80000">Superior</option>
                        </select>
                    </div>
                </div>          
                <div class="form-group">
                    <label for="bonos">Bono navidad: </label>
                    <div>
                        <select class="form-control" name="bonoV">
                            <option value="0">Eliga. . .</option>
                            <option value="20000">si</option>
                            <option value="0">no</option>
                        </select>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-block " name="enviar" value="enviar"> 
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar </button>

            </div>
        </form>



        <form name="form" method="get" action="Control_cargo">
            <div class=" col-lg-5">
                <div class="form-group ">
                    <h3>Calcular Bono por empelado</h3>
                    <label for="rut de la Persona">Rut:</label>
                    <input type="text" class="form-control" name="rut2">
                </div>
                <button type="submit" class="btn btn-primary btn-block " name="action" value="enviar">
                    <span class="glyphicon glyphicon-send" aria-hidden="true"></span> Enviar </button>

                <h2>Total del sueldo:</h2>
                <h3>$ ${cargo}</h3>  


            </div>
        </form>        
    </div>
</body>
</html>

