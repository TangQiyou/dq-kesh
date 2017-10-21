'use strict';

app.controller('SigninFormController', ['$scope', '$http',  function ($scope, $http) {
    $scope.user = {};
    $scope.login = function () {
    	$scope.data = [];
    	$.ajax({
			type:"post", 
		 	url:"../back/login",
			contentType:"application/json;charser=utf-8",
			data:JSON.stringify($scope.user),
			success:function(data){
				$scope.data = angular.fromJson(data);
				if($scope.data.code==1){
					window.location="index.html";
				}
			} 
		}); 
      
    };

}]);