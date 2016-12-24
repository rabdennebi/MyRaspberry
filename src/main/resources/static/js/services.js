angular.module('starter.services', [])
	.factory("testFactory", function($http) {
		var self = this;
		self.all = function() {
			return $http.get("/all").success(function(data) {	
				return data;
			});
		}
		return self;
	})
	.factory("raspFactory", function($http) {
		var self = this;
		self.ToggleOutput = function(arg1, arg2) {
			//var toto = 'ToggleOutput?pin='+arg1+'&resistance='+arg2;
			return $http.get('/ToggleOutput',{params:{pin:arg1,resistance:arg2}});
		};
		self.raspFactory.info =function(){
			return $http.get("/infoRasp").success(function(data) {				
				return data;
			});
		};
		return self;
	});