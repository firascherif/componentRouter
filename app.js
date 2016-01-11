var app = angular.module('myApp', ['ngNewRouter' ,'app.details', 'app.home'])
 app.controller('AppController', ['$router', function($router){
	 
	$router.config([
   {
     path: '/', component: {
        home : 'home',
        details : 'details'
     } 
    }
]);
	 
	 
	 
 }]);

