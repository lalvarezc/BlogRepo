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
	
}