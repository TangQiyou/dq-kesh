$(document).ready(function(){

	// 获取各种select
	getSelects();
	var userAccountFlag = false;
	
	//异步判断
	$("input[name='userAccount']").bind("change",function(){
		if($("input[name='userAccount']").val() != ""){
			// 先检查用户是否存在
	    	$.ajax({
				type:"get",
				url:"../web/isExist",
				data:"userAccount="+$("input[name='userAccount']").val(),
				dataType: "json",
				success:function(data){
					var result = eval(data);
					if(result.code==1){
						userAccountFlag = true;
					}
					else{
						swal({
							title:"账户已存在",
							text: "请重新填写",
							type:"warning",
							showConfirmButton: true,
						})
					}
				}
			});

		}
	});

	$.validator.setDefaults({
	    submitHandler: function() {
	      // 注册
	      if(userAccountFlag == true){
			var jsonData={
				"userAccount":$("input[name='userAccount']").val(),
				"userName":$("input[name='name']").val(),
				"userPwd":$("input[name='pwd']").val(),
				"email":$("input[name='email']").val(),
				"qq":$("input[name='qq']").val(),
				"tel":$("input[name='tel']").val(),
				"age":$("input[name='age']").val(),
				"gender":$("select[name='gender']").find("option:selected").val(),
				"college":$("select[name='college']").find("option:selected").val(),
				"status":$("select[name='status']").find("option:selected").val()
			};
			$.ajax({
				type:"post", 
			 	url:"../web/user",
			 	dataType:"json",
				contentType:"application/json;charser=utf-8",
				data:JSON.stringify(jsonData),
				success:function(data){
					var data = eval(data);
					if(data.code == 1){
						swal({
							title:"您已注册成为会员",
							text: "正在前往登录页面",
							type:"success",
							showConfirmButton: true,
						},function(){
                         	//window.location.reload();
							location.href = "login.html";
						});
						
					} else {
						swal({
							title:"注册失败",
							text: "请检查信息填写",
							type:"error",
							showConfirmButton: true,
						})
					}
				} 
				
			}); //---ajax
		}
	    }
	});
	$("#register-form").validate({
	    rules: {
	      userAccount:{
	      	required: true,
	      },
	      name: {
	        required: true,
	        minlength: 2
	      },
	      pwd: {
	        required: true,
	        minlength: 6
	      },
	      email: {
	        required: true,
	        email: true
	      },
	      qq: {
	        required: true,
	        maxlength: 10
	      },
	      tel: {
	      	isMobile:true,
	        required: true,
	        minlength: 11,
	        maxlength: 11
	      },
	      age: {
	      	required:true,
	      	maxlength:2
	      },
	      gender: {
	        required: true,
	      },
	       college: {
	        required: true,
	      },
	       status: {
	        required: true,
	      },
	    },
	    messages: {
	    	userAccount: {
	    		required:"账号必填",
	    	},
	    	name: {
	    		required:"用户名不能少于两位",
	    	},
	    	pwd: "密码不能少于六位",
	        email: "请输入一个正确的邮箱",
	        qq:"请输入正确QQ号码",
	        youbian:{
	        	required:"请输入六位邮政编码",
	        	isZipCode:"输入正确邮编",
	        },
	        age:{
	        	required:"请填写年龄",
	        },
	        tel: {
	        	isMobile:"请输入11位电话号码",
	        },
	        gender: "请选择性别",
	        college: "请选择学院",
	        status: "请选择身份"
	    },
	    errorPlacement: function(error, element) {
        	error.appendTo(element.nextAll(".error-tip"));
		}
		// ,
	 //    submitHandler: function(form) {

			   	
			
		// }//---submit
	});

})
	

