"use strict";
App.ModalShowNew=function(){
	
	var __init=function(){
		
		$(document).on("ModalCreateNew_message", function (evt) {
			 console.info(evt);
	   });
	
	}
	 /**public**/
	  return{
		 
	    init:function(){
	    	__init();
	    }
	       
	  };
	
}