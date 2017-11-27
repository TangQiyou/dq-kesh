$(document).on("click",".cancel",function(){
	var userid = getCookie("userid");
	
	if (userid == null || userid == ""){
		swal({
			title:"未登录",
			text: "无法注销账户",
			type:"warning",
			showConfirmButton: true
		});
	} else {
		setCookie("userid", "");
		swal({
			title:"成功注销",
			text: "返回登录界面",
			type:"success",
			showConfirmButton: true
			},function(){
			location.href = "login.html";	
		});
	}
});