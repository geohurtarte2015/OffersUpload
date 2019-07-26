

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Segmented Packages</title>
    
    <link href="plantilla/bower_components/charts/highcharts.js" rel="stylesheet">
    <link href="plantilla/bower_components/charts/jquery.highchartsTable.js" rel="stylesheet">

    <!-- Bootstrap -->
    <link href="plantilla/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="plantilla/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="plantilla/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="plantilla/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="plantilla/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    

    <!-- Custom Theme Style -->
    <link href="plantilla/build/css/custom.min.css" rel="stylesheet">
    
    <!-- Style Modal -->
     <style>
        .modal-header, h4, .close {
            background-color: #5cb85c;
            color:white !important;
            text-align: center;
            font-size: 30px;
        }
        .modal-footer {
            background-color: #f9f9f9;
        }
    </style>
     <style id="compiled-css" type="text/css">
    
        table.display tbody tr:nth-child(even):hover td{
            background-color: #ffc2c2;
        }

        table.display tbody tr:nth-child(odd):hover td {
            background-color: #ffc2c2;
        }


  </style>

    
 
    
  </head>

  <body class="nav-md">
      
      
    <% 
        String nombre = (String) session.getAttribute("nombre");    
        String apellido = (String) session.getAttribute("apellido");
        
        if (session.getAttribute("nombre") == null) {
            response.sendRedirect("index.jsp");
            nombre=null;
        } 
        
        //List<ResumeError> arrayIncomplete=(List<ResumeError>)request.getAttribute("arrayIncomplete");
        //List<ResumeError> arrayInvalid=(List<ResumeError>)request.getAttribute("arrayInvalid");
        //List<ResumeError> arrayNotExists=(List<ResumeError>)request.getAttribute("arrayNotExists");
        //List<ResumeError> arrayErrorIntern=(List<ResumeError>)request.getAttribute("arrayErrorIntern");
        //List<ResumeError> arrayServiceExits=(List<ResumeError>)request.getAttribute("arrayServiceExits");
        //List<ResumeError> arrayUnknown=(List<ResumeError>)request.getAttribute("arrayUnknown");
        //List<Object> vasGroupByCountry=(List<Object>)request.getAttribute("vasGroupByCountry");
        //List<ResumeError> arraySuccess=(List<ResumeError>)request.getAttribute("arraySuccess");
        //String test = (String) request.getAttribute("prueba");
    %>
         

        
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><span>CLARO</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile">
            
              <div class="profile_info">
                  <span>Bienvenido,<%=" "+nombre+" "+apellido%></span>
                <h2></h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />
             <br />
              <br />
               <br />
                <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                  <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="user.jsp">Creación de segmentación</a></li>          
                      <li><a href="creacion.jsp">Carga de clientes POS</a></li> 
                      <li><a href="eliminar.jsp">Eliminar clientes POS</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
      

            </div>
            <!-- /sidebar menu -->

         
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>

              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    Opciones
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">                    
                    <li><a href="EndSesion"><i class="fa fa-sign-out pull-right"></i> Salir</a></li>
                  </ul>
                </li>
         
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
                            
            <h1>Creación de segmentación</h1>
            
              <div class="modal-footer">
                   <form  method="post" role="form" action="SaveProduct">
                     <div class="panel-body">
                            
                            <div class="row">                            
                                <div class="col-sm-4">
                                    <div class="form-group">
                                            <label>Description</label>
                                            <input class="form-control" name="Description" id="Description" placeholder="Description">
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                            <label>Discount</label>
                                            <input class="form-control" name="Discount" id="Discount" placeholder="Discount">
                                    </div>
                                </div>
                                 <div class="col-sm-4">
                                    <div class="form-group">
                                            <label>Marcacion</label>
                                            <input class="form-control" name="Marcacion" id="Marcacion" placeholder="Marcacion">
                                    </div>
                                </div>
                            </div><!-- /.Nombre Apellido -->  
                            
                            <div class="row">                              
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label>Status</label>
                                        <select name="Status" id="Status" class="form-control" required="">
                                            <option value="A">Activo</option>
                                            <option value="I">Inactivo</option>                                          
                                        </select>
                                    </div>
                                </div>
                            </div><!-- /.Usuario Contraseña -->  
                            <br>
                            <br>
                                <div class="col-sm-4">
                                <button type="button" name="limpiar" id="limpiar" class="btn btn-lg btn-success btn-block">Limpiar</button>                                
                                </div>
                                <div class="col-sm-4">                            
                                <button type="submit" name="ingresar" value="Ingresar" class="btn btn-lg btn-success btn-block"/>Guardar</button>  
                                </div>
                            </div>
                   </form>
                  <br />

                  <table id="TBUSER" class="table table-striped table-bordered table-hover display" style="cursor:pointer" cellspacing="0" width="100%">  
                                          
                          <thead>
                                 <tr>
                                  <th>ID</th>
                                  <th>DESCRIPTION</th>
                                  <th>DISCOUNT</th>
                                  <th>STATUS</th>    
                                  <th>MARCACION</th>                                
                                 </tr>
                          </thead>
                    </table>
          
                  
                  
              </div>
       
     
          <br />
          
          



        
        </div>
        
        
        <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <form  method="post" role="form" action="UpdateProduct">
        <div class="modal-header" style="padding:35px 50px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4><span class="glyphicon glyphicon-lock"></span> Modifación de Producto</h4>
        </div>
          
        <div class="modal-body" style="padding:40px 50px;">
            <input hidden="true" type="text" name="idProductHidden" id="idProductHidden">       
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Descripcion</label>
              <input type="text" class="form-control" name="DescriptionUpdate" id="DescriptionUpdate" placeholder="Descripcion">
            </div>  
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Descuento</label>
              <input type="text" class="form-control" name="DiscountUpdate" id="DiscountUpdate" placeholder="Descuento">
            </div>  
            <div class="form-group">
              <label for="usrname"><span class="glyphicon glyphicon-user"></span> Marcacion</label>
              <input type="text" class="form-control" name="MarcacionUpdate" id="MarcacionUpdate" placeholder="Marcacion">
            </div>
        
              <div class="form-group">
                  <label for="usrname"><span class="glyphicon glyphicon-ok"></span><label>Status</label>
                  <select name="StatusUpdate" id="StatusUpdate" class="form-control" required="">
                      <option value="">Seleccionar..</option>
                      <option value="A">Activo</option>
                      <option value="I">Inactivo</option>
                  </select>
              </div>
              <br>
              <button type="submit" name="modificar" id="modificar" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Modificar</button>
          
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          
        </div>
        </form>
      </div>
      
    </div>
  </div> 
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Segmented Packages - Desarrollado por <a href="https://www.claro.com.gt">Desarrollo de Productos</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
      </div>
    </div>

      <!-- jQuery -->
    <script src="plantilla/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="plantilla/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="plantilla/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="plantilla/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="plantilla/vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="plantilla/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="plantilla/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="plantilla/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="plantilla/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="plantilla/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="plantilla/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="plantilla/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="plantilla/vendors/datatables.net-scroller/js/datatables.scroller.min.js"></script>
    <script src="plantilla/vendors/jszip/dist/jszip.min.js"></script>
    <script src="plantilla/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="plantilla/vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="plantilla/build/js/custom.min.js"></script>
  

    
     <script type="text/javascript">
        var id;
        var rol;
        
        $(document).ready(function(){
            
            
            $("#limpiar").click(function(){
                        $("#Description").val('');
                        $("#Discount").val('');
                        $("#Marcacion").val('');
                        $("#Password").val('');
                        document.getElementById("Rol").selectedIndex="0";
                        
            });             
        
             var tableUsers= $('#TBUSER').DataTable( {
                    "ajax" : {
                        "url": "ListProducts",
                        "type": "POST"
                    },
                        "global" : false,
                        "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
                        "dataType" : "json",
                        "columns" : [
                            {"title": "ID"},
                            {"title": "DESCRIPTION"},
                            {"title": "DISCOUNT"},
                            {"title": "STATUS"},
                            {"title": "MARCACION"}                         
                        ]
              
                    });
                    
             $('#TBUSER tbody').on('click', 'tr', function () {
                    var data = tableUsers.row( this ).data();
                        id = data[0];
                        
                         $.post("GetOneProduct",
                            {
                               id: id
                           },
                           function(json){
                               
                                if (confirm("¿Desea modificar?") == true) {                                
                                    $("#DescriptionUpdate").val(json.description);
                                    $("#DiscountUpdate").val(json.discount);
                                    $("#MarcacionUpdate").val(json.marcacion);              
                                    $("#StatusUpdate").val(json.status);
                                    $("#idProductHidden").val(id);                                   
                                    //$('#StatusUpdate option').eq(json.status).prop('selected', true);
                                    $("#myModal").modal();
                                } else {
                                   
                                }
                           });
                           
                        } ); 
                        
             
                    
         
            
            
         });
         
         
         
    </script>


  </body>
</html>

