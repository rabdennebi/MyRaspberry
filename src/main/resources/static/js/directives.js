angular.module('starter.directive', [])
.directive("test", function ()
{
    return{
        restrict: 'E',
        templateUrl: 'js/templates/test.html'
    }
});