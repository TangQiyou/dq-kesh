$(window).ready(function(){
	$.datetimepicker.setLocale('ch');
	$('#datetimepicker').datetimepicker({
		timepicker:false,  
		autoclose:true ,//选择日期后自动关闭
		format:"Y-m-d",      //格式化日期
		maxDate:new Date(),
		todayBtn: true 
	});
	$('.pull').click(function(){
		$(".hide-show").animate({
		    width:'toggle'
		 },"slow");
	});
 
	  $(".content-wrap").mpmansory(
	    {
	      childrenClass: 'data-wrap', // default is a div
	      columnClasses: 'add-data-class', //add classes to items
	      breakpoints:{
	        lg: 3, 
	        md: 4, 
	        sm: 6,
	        xs: 12
	      },
	     
	  });
	  
  	// 调用函数
  	getAnnouncement();//获取公告
  	getDataType();//获取数据类型
  	$(".content-wrap").append('<div class="notfindData">请选择需要查询的数据</div>');
  	$(".search-data").unbind('click');
  	$(".search-data").bind('click',function(){

  		$(".content-wrap").empty();
  		if($("input[name='data-time']").val() == "" && $(".data-type").find("option:selected").val() == ""){

  			swal({
					title:"请选择需要查询的数据",
					type:"warning",
					showConfirmButton: true,
				});

  			return;
  		}
  		if($(".data-type").find("option:selected").val() == "" && $("input[name='data-time']").val() != ""){

  			getDataByDate(); //根据日期获取数据
  		}
  		if($(".data-type").find("option:selected").val() != "" && $("input[name='data-time']").val() == ""){

  			getDataByType(); //根据类型获取数据
  		}
  		if($(".data-type").find("option:selected").val() != "" && $("input[name='data-time']").val() != ""){

  			getDataByDateAndType(); //根据日期和种类查询数据
  		}
  		

  	})


  	// 获取数据类型
  	function getDataType(){
  		$(".data-type").append('<option value="">选择类型</option>');
  		$.ajax({
  			type:"get",
			url:"../public/getCodeByType",
			data:"code_type="+"pic_type",
			datatype:"json",
			success:function(data){
				var data = eval(data);
				console.log(data);
				if(data.code == '1'){

					$.each(data.extend.list,function(i,type){

						var type = '<option value="'+type.codeValue+'">'+type.codeName+'</option>';
						
						$(".data-type").append(type);

					});

				}

			},error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
  		})
  	}


  	// 获取首页公告
  	function getAnnouncement(){
	  $.ajax({
			type:"get",
			url:"../web/announcements",
			datatype: "json",
			success:function(data){
				var data = eval(data);
				// console.log(data.extend.pageInfo.list);

				if(data.extend.pageInfo.list.length == 0){

					$(".announcement-titles").append("<p>暂无公告</p><hr>");
					
				}else{
					$.each(data.extend.pageInfo.list,function(i,ann){

						if(i == 5){

							return false;
						}
						var list = "<p><a href='announcement.html?annId="+ann.annId
									+"'>"+ann.annTitle+"</a></p><hr>";
			 			$(".announcement-titles").append(list);
						
					});
					$(".announcement-titles").after('<div class="get-more"><a href="announcement.html?annId=more">更多<span class="glyphicon glyphicon-chevron-right"></span></a></li>');
						
				}
			}
			,error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		})
	}

	// 根据时间获取数据
	function getDataByDate(){

		 var jsonData={
				"year":$("input[name='data-time']").val().substr(0,4),
				"month":$("input[name='data-time']").val().substr(5,2),
				"day":$("input[name='data-time']").val().substr(8,2)
			}
		$.ajax({
			type:"post",
			url:"../web/getPictureByDate",
			data:JSON.stringify(jsonData),
			dataType:"json",
			contentType:"application/json;charser=utf-8",
			success:function(data){
				var data = eval(data);
				console.log(data);

			
				if(data.code == '1'){

					if(data.extend.list.length !=0){

						$.each(data.extend.list,function(i,list){

							console.log(list.picType);

							var pic = '<div class="data-wrap"><div class="img-wrap"><a href="details.html?picId='+
										list.picId+'"><img src="'+
										list.url+'"/></a></div><div class="introduction-wrap"><div class="type-name">'+
										list.typeName+'</div><hr><div class="name">'+list.des+
										'</div><div class="create-time">'+list.creatTime+'</div></div></div>';
							
							$(".content-wrap").append(pic);

							// 此处获取数据类型接口
							
						})
					}else{

						$(".content-wrap").append('<div class="notfindData">未查询到该时间段的数据，请重新选择</div>');
					
					}
					
				}else{
					
					$(".content-wrap").append('<div class="notfindData">未查询到该时间段的数据，请重新选择</div>');
					
				}

				
			}
			,error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		})
	}

	// 根据类型获取数据
	function getDataByType(){

		$.ajax({
			type:"get",
			url:"../web/getPictureByType",
			data:"picType="+$(".data-type").find("option:selected").val(),
			dataType:"json",
			contentType:"application/json;charser=utf-8",
			success:function(data){
				var data = eval(data);
				console.log(data);

			
				if(data.code == '1'){

					if(data.extend.pictures.length !=0){

						$.each(data.extend.pictures,function(i,list){

							console.log(list.picId);

							var pic = '<div class="data-wrap"><div class="img-wrap"><a href="details.html?picId='+
										list.picId+'"><img src="'+
										list.url+'"/></a></div><div class="introduction-wrap"><div class="type-name">'+
										list.typeName+'</div><hr><div class="name">'+list.des+
										'</div><div class="create-time">'+list.creatTime+'</div></div></div>';
							
							$(".content-wrap").append(pic);

							// 此处获取数据类型接口
							
						})
					}else{

						$(".content-wrap").append('<div class="notfindData">未查询到该时间段的数据，请重新选择</div>');
					
					}
					
				}else{
					
					$(".content-wrap").append('<div class="notfindData">未查询到该时间段的数据，请重新选择</div>');
					
				}

				
			}
			,error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		})
	}

	// 根据时间和类型获取数据
	function getDataByDateAndType(){

		 var jsonData={
				"year":$("input[name='data-time']").val().substr(0,4),
				"month":$("input[name='data-time']").val().substr(5,2),
				"day":$("input[name='data-time']").val().substr(8,2),
				"picType":$(".data-type").find("option:selected").val(),
			}
		$.ajax({
			type:"post",
			url:"../web/getPictureByDateAndType",
			data:JSON.stringify(jsonData),
			dataType:"json",
			contentType:"application/json;charser=utf-8",
			success:function(data){
				var data = eval(data);
				console.log(data);

			
				if(data.code == '1'){

					
					//var pic = '<div class="data-wrap"><div class="img-wrap"><a href="details.html?picId='+
					//			data.extend.returnPicture.picId+'"><img src="'+
					//			data.extend.returnPicture.url+'"/></a></div><div class="introduction-wrap"><div class="type-name">'+
					//			data.extend.returnPicture.typeName+'</div><hr><div class="name">'+data.extend.returnPicture.des+
					//			'</div><div class="create-time">'+data.extend.returnPicture.creatTime+'</div></div></div>';
					//$(".content-wrap").append(pic);
					window.location.href = "details.html?picId="+data.extend.returnPicture.picId;

					
				}else{
					
					$(".content-wrap").append('<div class="notfindData">未查询到该时间段的数据，请重新选择</div>');
				}

				
			}
			,error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		})
	}


})