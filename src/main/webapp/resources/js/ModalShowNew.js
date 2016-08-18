"use strict";
App.ModalShowNew=function(){
	
    var __init=function(){
       
        $(document).on("Main_showNews", function (evt) {
        	__limpiarModal();
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
            	  var __htmlComment =
            		  '<div class="panel panel-default">' +
            		  	'<div class="panel-heading"><b>' + response.comments[i].userName + '</b> | ' + response.comments[i].userEmail + '</div>' + 
            		  	'<div class="panel-body">' + response.comments[i].message + '</div> </div>';
            	  
                  $("#div-comments-id").append(__htmlComment);
              }
          }
      });
  }
 
  var __addComment = function(data) {
	  
	  var comment = {
              message: $("#comment-input").val(),
              userName: $("#name-input").val(),
              userEmail: $("#email-input").val()
      }
	  
      if(__validateComment(comment)) {
    	  
          var url = "api/addComment/" + data;
          var promise = __ajax(url,"PUT", comment);
          promise.then(function(response){ 
              console.info(response);
        	  var __htmlComment =
        		  '<div class="panel panel-default">' +
        		  	'<div class="panel-heading"><b>' + response.userName + '</b> | ' + response.userEmail + '</div>' + 
        		  	'<div class="panel-body">' + response.message + '</div> </div>';
        	  
              $("#div-comments-id").append(__htmlComment);
              
    		  $.event.trigger({
    		      type: "ModalShowNew_NewComment",
    		      message: data,
    		      time: new Date()
    		    });
          });   
      }
  }
 
  var __validateComment = function(comment) {
     
      if(comment.message == "" || comment.userName == "" || comment.userEmail == "") {
          $("#comment-alert").removeClass("hidden");
          $("#comment-alert").fadeTo(2000, 500).slideUp(500, function(){
              $("#comment-alert").slideUp(500);
          });
          return false;
      } else {
          return true;
      }
  }
  
  var __limpiarModal = function (){
	  $("#comment-input").val("");
      $("#name-input").val("");
      $("#email-input").val("");
      $("#div-comments-id").empty();
  }
 
     /**public**/
      return{
         
        init:function(){
            __init();
        }
           
      };
   
}