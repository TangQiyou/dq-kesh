

$(document).ready(function() {
	$.datetimepicker.setLocale('ch');
	$('.datetimepicker').datetimepicker({
		timepicker:false,  
		autoclose:true ,//选择日期后自动关闭
		format:"Y-m-d",      //格式化日期
		maxDate:new Date(),
		todayBtn: true 
	});

	// 获取各种selects
	getSelects();
	
	// 调用获取用户信息函数
	findOneUserById();

	// 调用修改函数
	$(".modify-info-btn").unbind("click");
	$(".modify-info-btn").bind("click",function(){

		updateInformation();

	});

	$(".cancel-modify-btn").unbind("click");
	$(".cancel-modify-btn").bind("click",function(){

		window.location.reload();

	});


	// 调用修改密码函数
	$(".modify-pwd-btn").unbind("click");
	$(".modify-pwd-btn").bind("click",function(){

		if($("input[name='newpassword']").val() != $("input[name='confirmpassword']").val()){
			swal({
					title:"两次密码不一致，请重新确认",
					type:"warning",
					showConfirmButton: true,
				});
		}else{
			reSetPassword();
		}
		
	});

	
	// 调用查看已购商品函数
	getLeavewordByUserid(1);

	/**
	 * 根据ID获取用户信息
	 * 参数：用户ID
	 */
	function findOneUserById(){

		$.ajax({
			type:"get",
			url:"../web/user",
		    dataType:"json",
		    data:"id="+getCookie('userid'),
			contentType:"application/json;charser=utf-8",
			success: function(data){
				var user = eval(data.extend.user);
				console.log(user);

				$(".user-status .status").html(user.userName);
				$("input[name='username']").val(user.userName);
				$("input[name='qqcode']").val(user.qq);
				$("input[name='email']").val(user.email);
				$("input[name='phone']").val(user.tel);
				$("input[name='age']").val(user.age);

				$(".user-pic").find("img").attr("src",user.userHead);
				$("#modifyUserpic .picture").find("img").attr("src",user.userHead);

				$("select[name='gender']").val(user.gender);
				$("select[name='college']").val(user.college);
				$("select[name='status']").val(user.status);
				
			},
			error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
		})
	}
	
	/**
	 * 修改用户个人信息
	 * 参数：用户的个人信息
	 */
	function updateInformation(){
		
		var jsonData={
				"userId":getCookie('userid'),
				"userName":$("input[name='username']").val(),
				"email":$("input[name='email']").val(),
				"qq":$("input[name='qqcode']").val(),
				"tel":$("input[name='phone']").val(),
				"age":$("input[name='age']").val(),
				"gender":$("select[name='gender']").find("option:selected").val(),
				"college":$("select[name='college']").find("option:selected").val(),
				"status":$("select[name='status']").find("option:selected").val()
			};
		$.ajax({
			type:"put",
			url:"../web/user",
		    dataType:"json",
			contentType:"application/json;charser=utf-8",
			data:JSON.stringify(jsonData),
			success: function(data){
				var data = eval(data);
				
				if(data.code == 1){
					swal({
						title:"修改个人信息成功",
						type:"success",
						showConfirmButton: true,
					},function(){
						findOneUserById();
					});
				}else{
					swal({
						title:"修改信息失败，请重试",
						type:"error",
						showConfirmButton: true,
					});
				}
			},
			error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
		})
	}

	/**
	 * 用户修改密码
	 * 参数：新密码，原密码
	 */
	function reSetPassword(){

		var jsonData={
					"userId":getCookie('userid'),
					"oldPwd":$("input[name='oldpassword']").val(),
					"userPwd":$("input[name='confirmpassword']").val()
				};
		$.ajax({
			type:"put",
			url:"../web/updatePwd",
		    dataType:"json",
			contentType:"application/json;charser=utf-8",
			data:JSON.stringify(jsonData),
			success: function(data){
				var data = eval(data);
				console.log(data);
				if(data.code == 1){
					swal({
						title:"修改密码成功，下次请用新密码登录",
						type:"success",
						showConfirmButton: true,
					},function(){
						window.location.reload();
					});
				}else{
					swal({
						title:"修改密码失败，请重试",
						type:"error",
						showConfirmButton: true,
					});
				}
				
			},
			error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
		})
	}

	/**
	 * 用户修改头像
	 * 参数：formdata
	 */
	$('.userpic-upload-btn').unbind("click");
    $('.userpic-upload-btn').bind("click",function(){

	   var $this = $(this),
		    btn = $this.find('.upfile-pic'),
		    img1 = $this.prev("img");
		    img2 = $(".user-pic").find("img");

	   btn.on('change',function(){

		    var file = $(this)[0].files[0],
			    imgSrc = $(this)[0].value,
			    url = URL.createObjectURL(file);
		     
		     // console.log(url);
		    if (!/\.(jpg|jpeg|png|JPG|PNG|JPEG)$/.test(imgSrc)){
		     swal({
		     	title:"请上传jpg或png格式的图片！",
		     	showConfirmButton: true
		     });
		     return false;
		    }else{

		     img1.attr('src',url);
		     img1.css({'opacity':'1'});
		     img2.attr('src',url);
		     img2.css({'opacity':'1'});
		    }
		    
		    $('.modifyUserpic-btn').unbind("click");
    		$('.modifyUserpic-btn').bind("click",function(){

			    var formData = new FormData();
				var name = $("#upfile-pic").val();
				formData.append("file",$("#upfile-pic")[0].files[0]);
				formData.append("userId",getCookie('userid'));
				$.ajax({ 
					url : "../web/updateHead", 
					type : "post", 
					data : formData,
				    cache: false,  
				    contentType: false,  
				    processData: false,
					success : function(data) { 
						var data = eval(data);
						//console.log(data.attachment_id);
						if(data.code == 1){
							
							swal({
								title:"修改头像成功",
								type:"success",
								showConfirmButton: true,

							},function(){
								window.location.reload();
							});
						}else{
							swal({
								title:"修改头像失败，请重试",
								type:"error",
								showConfirmButton: true,

							});
						}
					}, 
					error:function(jqXHR, textStatus, errorThrown){
						 console.log(jqXHR);
						 console.log(errorThrown);
						 console.log(textStatus);
					}
				});
			})
		});
	});
 
});

var currentpage = 0;
function leavewordPages(pagesize){

	layui.use('laypage', function(){
	  var laypage = layui.laypage;
	  
	  //执行一个laypage实例
	  laypage.render({
	    elem: 'laypages_body', //注意，这里的 test1 是 ID，不用加 # 号
	    count: pagesize, //数据总数，从服务端得到
	    theme: '#000', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00 
	    limit: 5, //每页显示条数
        jump: function(e){ //触发分页后的回调

            if(currentpage != 0){
            	getLeavewordByUserid(e.curr); 
            	console.log(e.curr);
            }
                   
        }   
	  });
	  currentpage++; 
	});
	   
}

/**
 * 用户查看所有留言
 * 参数：用户ID
 */
function getLeavewordByUserid(pn){

	$(".leaveWord-table").find("tbody").empty();
	var jsonData={
				"pn":pn,
				"leaveUserId":getCookie('userid')
			};
	$.ajax({
		type:"POST",
		url:"../web/leavewords",
	    dataType:"json",
		contentType:"application/json;charser=utf-8",
		data:JSON.stringify(jsonData),
		success: function(data){
			var data = eval(data);
			console.log(data);
			if(data.code == 1){

				if(currentpage == 0){
					console.log(currentpage);
					leavewordPages(data.extend.pageInfo.total);
					currentpage ++;
				}
				
				if (data.extend.pageInfo.pages == 0){
					$(".leaveWord-table").find("tbody").append("<tr><td colspan='5'>您还没有留言....</td></tr>");
				}
				$.each(data.extend.pageInfo.list,function(i,word){

					
					var leavewords = '<tr><td><nobr>'+word.leaveTitle+
									'</nobr></td><td>'+word.leaveTime+'</td><td>'+word.isResponsedName+
									'</td><td><button class="btn btn-default" onclick="seeLeavewordFun('+word.leaveId+')" data-toggle="modal" data-target="#seeLeaveword">'
									+'<span class="glyphicon glyphicon-eye-open"></span>查看</button>'
									+'<button class="btn btn-default" onclick="modifyLeavewordFun('+word.leaveId+','+pn+')" data-toggle="modal" data-target="#modifyLeaveword">'
									+'<span class="glyphicon glyphicon-edit"></span>修改</button>'
									+'<button class="btn btn-default" onclick="deleteLeavewordFun('+word.leaveId+','+pn+','+data.extend.pageInfo.total+')" data-toggle="modal" data-target="#deleteLeaveword">'
									+'<span class="glyphicon glyphicon-remove"></span>删除</button></td></tr>';
					
					$(".leaveWord-table").find("tbody").append(leavewords);
					// console.log(leavewords);
				});
				
			}else{

				$(".leaveWord-table").find("tbody").append("<tr><td colspan='5'>您还没有留言....</td></tr>");
			
			}
			
		},
		error:function(jqXHR, textStatus, errorThrown){
			 console.log(jqXHR);
			 console.log(errorThrown);
			 console.log(textStatus);
		}
	})
}


	/**
	 * 用户添加留言
	 * 参数：留言信息
	 */
	function addLeavewordFun(){

		$("#addLeaveword").find("input[name='title-input']").val("");
		$("#addLeaveword").find("textarea").val("");

		$('.addLeaveword-btn').unbind("click");
		$('.addLeaveword-btn').bind("click",function(){

			var jsonData={
					"leaveUserId":getCookie('userid'),
				    "leaveTitle":$("#addLeaveword").find("input[name='title-input']").val(),
				    "leaveContent":$("#addLeaveword").find("textarea").val()
				}
			$.ajax({
				type:"post",
				url:"../web/leaveword",
				data:JSON.stringify(jsonData),
			    dataType:"json",
				contentType:"application/json;charser=utf-8",
				success: function(data){
					var data = eval(data);
					console.log(data);
					if(data.code == 1){
						swal({
							title:"添加留言成功",
							type:"success",
							showConfirmButton: true,
							timer:2000,

						},function(){
							$('#addLeaveword').modal('hide');
							currentpage = 0;
							getLeavewordByUserid(1);
						});
						
					}else{
						swal({
							title:"添加留言失败，请重试",
							type:"error",
							showConfirmButton: true,
						});
					}
					
				},
				error:function(jqXHR, textStatus, errorThrown){
					 console.log(jqXHR);
					 console.log(errorThrown);
					 console.log(textStatus);
				}
			});
		})
	}

	/**
	 * 用户修改留言
	 * 参数：留言信息
	 */
	function modifyLeavewordFun(id,pn){

		seeLeavewordFun(id);

		$('.modifyLeaveword-btn').unbind("click");
		$('.modifyLeaveword-btn').bind("click",function(){

			var jsonData={
				    "leaveId":id,
				    "leaveTitle":$("#modifyLeaveword").find("input[name='title-input']").val(),
				    "leaveContent":$("#modifyLeaveword").find("textarea").val()
				}
			$.ajax({
				type:"put",
				url:"../web/leaveword",
			    dataType:"json",
			    data:JSON.stringify(jsonData),
				contentType:"application/json;charser=utf-8",
				success: function(data){
					var data = eval(data);
					console.log(data);
					if(data.code == 1){
						swal({
							title:"修改留言成功",
							type:"success",
							timer:2000,

						},function(){
							$('#modifyLeaveword').modal('hide');
							getLeavewordByUserid(pn);
						});
						
					}else{
						swal({
							title:"修改留言失败，请重试",
							type:"error",
							showConfirmButton: true,
						});
					}
					
				},
				error:function(jqXHR, textStatus, errorThrown){
					 console.log(jqXHR);
					 console.log(errorThrown);
					 console.log(textStatus);
				}
			});
		})
	}

	/**
	 * 用户查看留言详情
	 * 参数：留言ID
	 */

	function seeLeavewordFun(id){

		$("#seeLeaveword").find(".leaveTitle").html("");
		$("#seeLeaveword").find(".leaveTime").html("");
		$("#seeLeaveword").find(".leaveContent").html("");
		$("#seeLeaveword").find(".replay-details").html("");

		$("#modifyLeaveword").find("input[name='title-input']").val("");
		$("#modifyLeaveword").find("input[name='time-input']").val("");
		$("#modifyLeaveword").find("textarea").val("");

		$.ajax({
			type:"get",
			url:"../web/leaveword",
			data:"id="+id,
		    dataType:"json",
			contentType:"application/json;charser=utf-8",
			success: function(data){
				var leaveword = eval(data.extend.leaveword);
				console.log(data);
				if(data.code == 1){
					
					$("#seeLeaveword").find(".leaveTitle").html(leaveword.leaveTitle);
					$("#seeLeaveword").find(".leaveTime").html(leaveword.leaveTime);
					$("#seeLeaveword").find(".leaveContent").html(leaveword.leaveContent);

					if(leaveword.isResponsed == 50){

						$("#seeLeaveword").find(".replay-details").html(data.extend.response.responseContent);

					}else{
						$("#seeLeaveword").find(".replay-details").html("管理员暂未回复");
					}
					

					$("#modifyLeaveword").find("input[name='title-input']").val(leaveword.leaveTitle);
					$("#modifyLeaveword").find("input[name='time-input']").val(leaveword.leaveTime);
					$("#modifyLeaveword").find("textarea").val(leaveword.leaveContent);

				}else{
					swal({
						title:"获取留言详情失败",
						type:"error",
						showConfirmButton: true,
					});
				}
				
			},
			error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
		})
	}

	/**
	 * 用户删除留言
	 * 参数：留言ID
	 */
	function deleteLeavewordFun(id,pn,total){

		$('.deleteLeaveword-btn').unbind("click");
		$('.deleteLeaveword-btn').bind("click",function(){

			$.ajax({
				type:"delete",
				url:"../web/leaveword/"+id,
			    dataType:"json",
				contentType:"application/json;charser=utf-8",
				success: function(data){
					var data = eval(data);
					console.log(data);
					if(data.code == 1){
						swal({
							title:"删除留言成功",
							type:"success",
							showConfirmButton:true,
							timer:2000,

						},function(){
							
							currentpage = 0;
							if(currentpage == 0){
								
								leavewordPages(total*1-1);
								
								$('#deleteLeaveword').modal('hide');
								getLeavewordByUserid(1);
								currentpage ++;
							}
							
						});
						
					}else{
						swal({
							title:"删除留言失败，请重试",
							type:"error",
							showConfirmButton: true,
						});
					}
					
				},
				error:function(jqXHR, textStatus, errorThrown){
					 console.log(jqXHR);
					 console.log(errorThrown);
					 console.log(textStatus);
				}
			});
		})
	}


	