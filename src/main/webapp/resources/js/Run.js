"use strict";
var main= App.Main();
main.init();
//example
main.createNews();

var modalCrateNew= App.ModalCreateNew();
modalCrateNew.newPost();

var modalShowNew=App.ModalShowNew();
modalShowNew.init();