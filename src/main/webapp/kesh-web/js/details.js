$(window).ready(function(){


	// var $id;
 //    function getPicId(){

 //     	// 获取公告ID 
 //     	(function($){
	// 		$.getUrlParam = function(id){

	// 			var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
	// 				r = window.location.search.substr(1).match(reg);
	// 			if (r!=null) 

	// 				return unescape(r[2]);
	// 				return null;
	// 			}
	// 		})(jQuery);
     
	//    	$id = $.getUrlParam('picId');
 //     	console.log("getPicId:"+$id);

 //    } //----getAnncId()
    
 //   getPicId();

// 获取图片详情
 var Request = new Object();
   Request = GetRequest();
   var picTime = Request['picTime'];
   var picType = Request['picType'];
   
   console.log(picType);
   console.log(picTime);

   var year = picTime.substr(0,4);
   var month = picTime.substr(5,2);
   var day = picTime.substr(8,2);
   
   getDataDetails(year,month,day,picType);

   // 获取前一天图形
   // $(".preday").unbind('click');
   // $(".preday").bind('click',function(){
   	$(".details-container").on("click",".preday",function(){

   		day = day-1;
   		if(day<10){
   			day = "0"+day;
   		}
   		if(day == 0){
   			month = month-1;
   			if(month<10){
   				month = "0"+month;
   			}
   		}if(month == 0){
   			year = year-1;
   		}
   		picTime = year+"-"+month+"-"+day;
   		window.location.href="details.html?picTime="+picTime+"&picType="+picType;
   	})

	$(".details-container").on("click",".nextday",function(){

   		if(day*1<9){

   			day = day*1+1;
   			day = "0"+day;

   		}else{

   			day = day*1+1;
   		}

   		if(day == 31){
   			if(month*1<9){

   				month = month*1+1;
   				month = "0"+month;
   			}else{
   				month = month*1+1;
   			}
   		}if(month == 12){
   			year = year*1+1;
   		}
   		picTime = year+"-"+month+"-"+day;
   		window.location.href="details.html?picTime="+picTime+"&picType="+picType;
   	})


   function getDataDetails(year,month,day,picType){

		 var jsonData={
				"year":year,
				"month":month,
				"day":day,
				"picType":picType,
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
					 var detail = '<div class="data-wrap"><div class="img-wrap"><img src="'+
					 			data.extend.returnPicture.url+'"/></div><div class="introduction-wrap"><div class="type-name">'+
					 			data.extend.returnPicture.typeName+'</div><hr><p class="tips"> 图形介绍：</p><div class="name">'+
					 			data.extend.returnPicture.des+'</div><p class="tips">制作时间：</p><div class="create-time">'+
					 			data.extend.returnPicture.creatTime+'</div></div></div><div class="btns"><button class="btn btn-default preday">'+
					 			'<span class="glyphicon glyphicon-hand-left"></span>前一天</button>'+
					 			'<button class="btn btn-default nextday">后一天<span class="glyphicon glyphicon-hand-right"></span></button>'+
					 			'<form action="../web/downloadPicture" method="post">'+
					 			'<input type="hidden" name="picType" value="'+data.extend.returnPicture.picType+'"/>'+
					 			'<input type="hidden" name="year" value="'+data.extend.returnPicture.year+'"/>'+
					 			'<input type="hidden" name="month" value="'+data.extend.returnPicture.month+'"/>'+
					 			'<input type="hidden" name="day" value="'+data.extend.returnPicture.day+'"/>'+
					 			'<button class="btn btn-default download"><span class="glyphicon glyphicon-download"></span>下载</button></form></div>';
					$(".details-container").append(detail);

				}else{

					$(".details-container").append('<div class="notfindData" style="color:red;">暂无该日期数据</div> ');
					
				}

			},error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		});
	}


})