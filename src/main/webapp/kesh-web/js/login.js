$(document).ready(function(){

	var codeflag = 0;
	//验证码
	var verifyCode = new GVerify("codearea");
	$("#code-input").blur(function(){

		var res = verifyCode.validate($("#code-input").val());
		if(res){

			$(".code-tip").css("color","green");
			$(".code-tip").removeClass('glyphicon-remove-sign');
			$(".code-tip").addClass('glyphicon-ok-sign');
			codeflag = 1;
			console.log("IN_FLAG"+codeflag);
		}else{
			codeflag = 0;
			$(".code-tip").css("color","red");
			$(".code-tip").removeClass('glyphicon-ok-sign');
			$(".code-tip").addClass('glyphicon-remove-sign');
			
		}
	});

	$(".login-btn").bind("click",function(){
		
		if(codeflag != 1){
			swal({
					title:"验证码错误",
					type:"error",
					showConfirmButton: true,
				});

			return;
		}
		if($("input[name='userAccount']").val() == "" || $("input[name='password']").val() == ""){
			swal({
					title:"用户名或密码不能为空",
					type:"error",
					showConfirmButton: true,
				});

			return;
		}else{
			var jsonData={
					"userAccount":$("input[name='userAccount']").val(),
	    			"userPwd":$("input[name='password']").val()
				};
				$.ajax({
					type:"post", 
				 	url:"../web/userLogin",
				    dataType:"json",
					contentType:"application/json;charser=utf-8",
					data:JSON.stringify(jsonData),
					success:function(data){
						console.log(data);

						if(data.code==1){

						    setCookie('userid',data.extend.user.userId);
						    
							swal({
								title:"登录成功",
								text:"正在前往个人中心",
								type:"success",
								showConfirmButton: true
								},function(){
								location.href = "personal.html";	
							});
							
						}
						else {
							swal({
								title:"用户名或密码输入错误",
								type:"error",
								showConfirmButton: true,
							});
							
						}
					} 
				}); 
			
		}
})		
		
	
})

