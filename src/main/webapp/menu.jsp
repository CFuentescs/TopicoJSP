<%-- 
    Document   : menu
    Created on : 20-10-2017, 12:49:51
    Author     : Alumno
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Solemne 2</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
      <div class="col-lg-9 col-sm-12">
        <div class="well row">

          <h3>Bienvenido!</h3>
          <p>Sistema de control y asignacion de bonos para las cargas familiares de los empleados de la contructora "Desarollo Sustentable".</p>
        </div>
        <div class="row">
            
            <div class="col-lg-2 aside">
                
                
            </div>            
          <div class="col-lg-8 aside">
            <div class="well row">
              <center>
                  <div class="col-sm-4 col-lg-12">                
                <img src="http://localhost:8080/Solemne2v2.0/images/bajar.jpg" alt="" class="img-thumbnail">
              </div>
               </center>   
                  
              <div class="col-sm-8 col-lg-12">            
                <h4>Sistema Desarrollo Sustentable</h4>
                <p class="text-justify">La reputación de integridad y de conducta ética son para nuestra empresa uno de sus bienes más preciados. Por ello, es tarea de cada uno de los miembros, mantener esa confianza depositada.</p>
              </div>
            </div>
          </div>
                
        </div>
      </div>
      
        <iframe  width="400" height="600"  class="embed-responsive-item col-sm-3 col-xs-12 " src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1664.771855116723!2d-70.61586352953265!3d-33.4351384863393!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x54cf17d9cfb58729!2sUNAB+-+Campus+Antonio+Varas!5e0!3m2!1ses!2ses!4v1499227659550" style="border:0; margin-bottom: 13px;" allowfullscreen></iframe>
    
     
    </div>
  </section>
        
        
        
        
    <script>
        $(document).ready(function () {
            $('.dropdown a.test').on("click", function (e) {
                $(this).next('ul').toggle();
                e.stopPropagation();
                e.preventDefault();
            });
        });
    </script>
    <div class="container">


    </div>

</body>
</html>
