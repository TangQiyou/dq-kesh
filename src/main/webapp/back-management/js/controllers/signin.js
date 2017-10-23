'use strict';

app.controller('SigninFormController', ['$scope', '$http',  function ($scope, $http) {
    $scope.user = {};
    $scope.login = function () {
    	$scope.data = [];
    	$("#loginBtn").text('登陆中...');
    	$.ajax({
			type:"post", 
		 	url:"../back/login",
			contentType:"application/json;charser=utf-8",
			data:JSON.stringify($scope.user),
			success:function(data){
				$scope.data = angular.fromJson(data);
				if($scope.data.code==1){
					window.location="index.html";
				} else {
					$("#pwd").val("");
					$("#loginBtn").text('登陆');
					alert('管理员用户名或密码错误，请重新输入。');
					
				}
			},
			error:function(){
				$("#loginBtn").text('登陆');
				alert('未收到服务器响应,请稍后重试。');
			}
		}); 
      
    };

}]);