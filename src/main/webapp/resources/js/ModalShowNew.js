"use strict";
App.ModalShowNew=function(){
	
	var __init=function(){
		
		$(document).on("ModalCreateNew_NewCreated", function () {
			__limpiar();
			 __readAll();
	   });
	
	}
	 /**public**/
	  return{
		 
	    init:function(){
	    	__init();
	    }
	       
	  };
	
   
    var __init=function(){
       
        $(document).on("Main_showNews", function (evt) {
             console.info(evt);
             __showNews(evt.message);
             
            $("#submit-comment-btn").click(function(){
                __addComment(evt.message);
            });
        });
    }
 
  var __ajax = function(url, method, data){
       
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
      return dfd.promise();
  };
 
  var __showNews= function(data){
      var url = "api/read/" + data;
      var promise = __ajax(url,"GET", null);
      promise.then(function(response){
    	  var newDate = new Date(response.date);
          $("#post-title-id").html(response.title);
          $("#post-body-id").html(response.content);
          $("#post-author-name").html(response.author.name);
          $("#post-pubdate").html(newDate.toLocaleString());
         
          if(response.comments.length > 0) {
              for (var i = 0; i < response.comments.length; i++) {
                  $("#div-comments-id").append("<p>"+response.comments[i].userName +": <br>" + response.comments[i].message+"</p>");
              }
          } else {
              $("#div-comments-id").append("<p>There are no comments yet.</p>");
          }
      });
  }
 
  var __addComment = function(data) {
      if(__validateComment()) {
          var url = "api/addComment/" + data;
          var comment = {
                  message: $("#comment-input").val(),
                  userName: $("#name-input").val(),
                  userEmail: $("#email-input").val()
          }
         
          var promise = __ajax(url,"PUT", comment);
          promise.then(function(response){ 
              console.info(response);
              alert("Comment published succesfully");
          });
      }
     
  }
 
  var __validateComment = function() {
     
      var message = $("#comment-input").val();
      var userName = $("#name-input").val();
      var userEmail = $("#email-input").val();
     
      if(message == "" || userName == "" || userEmail == "") {
          $("#comment-alert").removeClass("hidden");
          $("#comment-alert").fadeTo(2000, 500).slideUp(500, function(){
              $("#comment-alert").slideUp(500);
          });
          return false;
      } else {
          return true;
      }
  }
 
     /**public**/
      return{
         
        init:function(){
            __init();
        }
           
      };
   
}