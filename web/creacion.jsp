

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
    
    
    <!-- Bootstrap CSS-->
    <link href="plantilla/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Jquery -->
     <script src="plantilla/js/jquery-1.9.1.min.js"></script>
   
    
    <!-- Boostrap Js -->
    <script src="plantilla/js/bootstrap.min.js"></script> 
    

    <!-- Font Awesome -->
    <link href="plantilla/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="plantilla/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="plantilla/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    
    <!-- Alert Bootbox -->
    <script src="plantilla/bootbox/bootbox.min.js"></script> 
    
   
    <!-- Custom Theme Style -->
    <link href="plantilla/build/css/custom.min.css" rel="stylesheet">
    
     <!-- Datatables -->
    <link href="plantilla/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="plantilla/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    
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

    
 
    
  </head>

  <body class="nav-md">
      
  
      
    <% 
        String nombre = (String) session.getAttribute("nombre");    
        String apellido = (String) session.getAttribute("apellido");
        
        if (session.getAttribute("nombre") == null) {
            response.sendRedirect("index.jsp");
            nombre=null;
        } 
   
   
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
                     <!-- <li><a href="#">Estadisticas</a></li>  -->
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
                     
                 
            <h1>Carga de números por selección de segmentación</h1>            
            <div class="modal-footer">
                  
                <form  method="post" role="form" action="Upload" enctype="multipart/form-data" id="fileUploadFormList">
                    <input type="hidden" id="idUpload" name="idUpload" value="0"> 
                     <div class="panel-body">  
                            <div class="col-sm-4">
                                    <div class="form-group">
                                        <label>Elegir segmentación</label>
                                        <select name="Product" id="Product" class="form-control" required="">
                                         
                                        </select>
                                    </div>
                                </div>
                     </div>
                    <div class="panel-body">  
                  
                        <div class="col-sm-4">                                
                            <div class="form-group">
                                <label for="file" id="labelFileList" name="labelFileList"></label>                                     
                                <input type="file" class="form-control-file" name="fileList" id="fileList">
                                <button type="button" class="btn btn-danger" data-loading-text="Loading ..."  id="btnSubmitList"> Cargar </button>
                             <!-- <input type="submit" value="Submit" value="uploadList" id="btnSubmitList">  -->
                            </div>                                 
                        </div>     
                       
                    </div>
                  
                </form>
                <div class="container">
                     <div id="alertsWebservice"></div>
                       <div id="alertsInsert"></div>
                       <div id="alertsUpload"></div> 
                    
                </div>
                <div class="container">
                <div class="col-sm-4"> 
                <h2>Lista de registro(s) con errores</h2>  
                </div>
                </div>
                <div class="container">
                     <table id="TBERROR" class="table table-striped table-bordered table-hover display" style="cursor:pointer" cellspacing="0" width="100%">  
                                          
                          <thead>
                                 <tr>                               
                                  <th>FILA</th>
                                  <th>DESCRIPCION</th>                                                        
                                 </tr>
                          </thead>
                    </table>
                </div>
                     
                
            </div>       
   

            <br />

          



        
        </div>
        

        
      

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


    

    <!-- Custom Theme Scripts -->
    <script src="plantilla/build/js/custom.min.js"></script>
    
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
  

    
     <script type="text/javascript">
        var id;
        var rol;
        var data = new FormData();
        

        
        $(document).ready(function(){  
            
        $.post("GetProudct", function(json){ 
               $("#Product").append('<option value="-1">Seleccionar...</option>');
                $.each(json, function (key,value) {
                    $.each(value, function (id, description) {
                        $("#Product").append('<option value="'+id+'">'+description+'</option>');
                    });
                });
               
                        
            
            });
            
            
        var tableError= $('#TBERROR').DataTable( {
            "ajax" : {
            "url": "GetDetailsError",
            "type": "POST",
            "data" : function(d){                            
                            d.idUpload = $("#idUpload").val();                           
                            }              
             },           
            "global" : false,
            "lengthMenu": [[ 4, -1], [ 4,20,"All"]],
            "dataType" : "json",
            "dom" : "Bfrtip",
            "buttons" : [
                  'csv', 'excel'
                       ],
            "columns" : [           
            {"title": "FILA"},
            {"title": "DESCRIPCION"}                                                               
            ]

        });
           
        $("#btnSubmitList").click(function (event) {
            
                    $(this).button('loading').delay(1000).queue(function() {
                            
                    //stop submit the form, we will post it manually.
                    event.preventDefault();

                    // Get form
                    var form = $('#fileUploadFormList')[0];

                    // Create an FormData object 
                    var data = new FormData(form);

                    // If you want to add an extra field for the FormData
                    data.append("id",$( "#Product" ).val());

                    // disabled the submit button
                    $("#btnSubmitList").prop("disabled", true);

                    $.ajax({
                        type: "POST",
                        enctype: 'multipart/form-data',
                        url: "Upload",
                        data: data,
                        processData: false,
                        contentType: false,
                        cache: false,
                        timeout: 600000,
                        success: function (data) {   
                            $("#btnSubmitList").button('reset');
                            $("#btnSubmitList").dequeue();
                            bootbox.alert({
                                message: "Cargado",
                                callback: function () {     
                                   
                                    $("#idUpload").val(data.idUpload);
                                    tableError.ajax.reload();
                                    $("#idUpload").val('0');
                                    
                                    if (data.webservice == "Exito") {
                                         $('#alertsWebservice').html("<div class='alert alert-success alert-dismissible'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> <strong>Resultado </strong> "+"Respuesta de la actualizacion de los registros: "+data.webservice+"</div>");        
                                    }else{
                                        $('#alertsWebservice').html("<div class='alert alert-danger alert-dismissible'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> <strong>Resultado </strong>"+"Error en respuesta de actualizacion de registros: "+data.webservice+"</div>");                                         
                                    }
                                   
                                    $('#alertsUpload').html("<div class='alert alert-info alert-dismissible'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> <strong>Resultado </strong>"+"Numero de registros ingresados: "+data.countInsert+"</div>");                                        
                                                                    
                                                                  
                                     if (data.responseResumeMsisdn == "ok" && data.responseResumeFile == "ok") {                                         
                                          $('#alertsInsert').html("<div class='alert alert-success alert-dismissible'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> <strong>Resultado </strong>"+"Respuesta ingreso de MSISDN: "+data.responseDescriptionMsisdn+"</div>");                                         
                                     }else{                                         
                                         $('#alertsInsert').html("<div class='alert alert-danger alert-dismissible'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a> <strong>Resultado </strong>"+"Error ingreso MSISDN: "+data.responseDescriptionMsisdn+" y "+data.responseDescriptionFile+"</div>");
                                     }
                                    
                                                                       
                                    $("#labelFileList").val('');
                                    $("#fileList").val('');
                                },
                                size: 'small'
                            });
                            
                            $("#btnSubmitList").prop("disabled", false);
                        },
                        error: function (e) {
                              bootbox.alert({
                                message: "Error en carga del archivo",
                                callback: function () {
                                    $("#labelFileList").val('');
                                    $("#fileList").val('');
                                },
                                size: 'small'
                            });
                            $("#btnSubmitList").prop("disabled", false);
                        }
                    });
               
                     //$(this).dequeue();  
                    }); 
              


            });
            
           
            
            
        $("#limpiar").click(function(){
                        $("#stb").val('');
                        $("#address").val('');
                        $("#packs").val('');  
            }); 
            
            
           $("#modificar").click(function(){
                $("#idRolHidden").val($("#RolUpdate").prop('selectedIndex')); 
            });
            
            
     
            
         });
         
         
         
    </script>


  </body>
</html>

