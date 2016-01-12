var app = angular.module('myApp', ['ngNewRouter' , 'app.form','app.details', 'app.home' , 'app.login'])
 app.controller('AppController', ['$router', function($router){
	 
	$router.config([
   {
     path: '/', component: {
		form : 'form',
        details : 'details',
        home : 'home',
		login : 'login'
     } 
    }
]);	 
}]);

