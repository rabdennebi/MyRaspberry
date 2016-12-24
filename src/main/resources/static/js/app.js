//var app = angular.module("MyCat", []);
var myapp=angular.module('starter',['ngRoute','starter.controllers','starter.directive']);
//angular.module('starter', ['starter.controllers', 'starter.services', 'starter.directives'])

//.run(function() {})
myapp.config(function($routeProvider) { 
    $routeProvider
    .when('/home', {
        templateUrl: 'templates/test.html'
    })
    .when('/raspberry', {
        templateUrl: 'templates/raspberry.html'
//        	,
//        controller: 'raspCtrl'
    })
    .otherwise({
        controller:'DefautlCtrl'
    });
});
 