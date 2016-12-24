angular.module('starter.controllers', ['starter.services'])
.controller("TestCtrl", function($scope,testFactory) {
	$scope.produits = [];

	testFactory.all().then(function(data){				
			$scope.produits=data.data;
			console.log($scope.produits);
	});
})
.controller("raspCtrl", function($scope,raspFactory) {
	$scope.info=[];
	raspFactory.info().then(function(data){				
		$scope.info=data.data;
		console.log($scope.info);
});
})
.controller("ToggleOutputCtrl", function($scope,raspFactory) {
	raspFactory.ToggleOutput($scope.arg1,$scope.arg2);
})
.controller("DefautlCtrl", function($scope) {
	
});