
"use strict";
App.Main=function(){

	
	var __htmlTitle;
	var __htmlContent;
	var __htmlAuthor;
	var __htmlNComments;
	
  var __init=function(){

    console.info("starting...");
    $("#new_post_id").click(function(){
         $("#modal_create_post_id").modal('show');
         document.getElementById("id_warning").className="bg-warning hide";
    });

    $("#btn_see_post_1_id").click(function(){
         $("#modal_see_post_id").modal('show');
    });

	__readAll();
	$(document).on("ModalCreateNew_NewCreated", function () {
		 __limpiar();
		 __readAll();
   });
    

  };
  
  
  
  var __ajax=function(url, method, data){
	
	  if(data!=null){
		  data=JSON.stringify(data);
	  }else{
		  data=null;
	  }
      var dfd= new $.Deferred()
      $.ajax({
    	  url         : url,
          async       : true,
          type        : method,
          contentType : "application/json",
          data        : data,
          success     : dfd.resolve,
          error       : dfd.resolve
      });
      return   dfd.promise();
	  
  };
  

  var __readAll= function(){	 
	  var promise=__ajax("api/readAll","GET",null);
	  promise.then(function(response){		  
		  console.info(response);
		  
		  for (var int = 0; int < response.length; int++) {
			console.log(response[int].title);
			
			__renderizar(response[int]);
			
		}
		 
		  
	  });
		 
  };
  
  var __renderizar= function(response){
	  __htmlTitle=response.title;
		__htmlContent=response.content;
		__htmlAuthor=response.author.name;
		__htmlNComments=response.comments.length;
		var d = new Date(response.date);
		var htmlDate=d.toLocaleString();
		var idBoton="btn_"+response.id+"_id";
		var htmlNoticia='<div<div class="container">' +
		  '<div class="col-md-10 blogShort">'+
		    '<h1>'+__htmlTitle+'</h1>'+
		    '<!--<em>This snippet use <a href="http://bootsnipp.com/snippets/featured/sexy-sidebar-navigation" target="_blank">Sexy Sidebar Navigation</a></em>-->'+
		    '<article><p>'+__htmlContent+
		    '</p></article>'+
		    '<div class="row">'+
		        '<div class="span8">'+
		            '<p></p>'+
		            '<p>'+
		            '   <i class="glyphicon glyphicon-user"></i> by <b>'+__htmlAuthor+'</b>'+
		             '    | '+
		              ' <i class="glyphicon glyphicon-calendar"></i>'+htmlDate+
		                ' | '+
		                '<i class="glyphicon glyphicon-comment"></i>'+__htmlNComments+' Comments'+
		            '</p>'+
		        '</div>'+
		    '</div>'+
		    '<a class="btn btn-blog pull-right marginBottom10" href="#" id='+idBoton+'>READ MORE</a>'+
		'</div>'+
		   
		 '<!--end:  news  -->'+    
		     '</div></div></div>';
	  
	  __dibujarListadoNews(htmlNoticia);
	  __asignarEvento(idBoton,response.id);
  };
  
  
  var __asignarEvento=function(idBoton,idNoticia){
	  $("#"+idBoton).click(function(){
		  $.event.trigger({
		      type: "Main_showNews",
		      message: idNoticia,
		      time: new Date()
		    });
		  $("#modal_see_post_id").modal('show');
	  })
  };
  
  var __dibujarListadoNews=function(htmlNews){
	  $("#listadoNewsId").append(htmlNews);
	  
  }; 
  
  var __limpiar= function(){
	  $( "#listadoNewsId" ).empty();
  };
  
  /** public**/
  return{
	 
    init:function(){
    	__init();
    }
    
    

  };

};
