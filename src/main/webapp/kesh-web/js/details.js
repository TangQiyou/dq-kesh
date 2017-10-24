$(window).ready(function(){


	var $id;
    function getPicId(){

     	// 获取公告ID 
     	(function($){
			$.getUrlParam = function(id){

				var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
					r = window.location.search.substr(1).match(reg);
				if (r!=null) 

					return unescape(r[2]);
					return null;
				}
			})(jQuery);
     
	   	$id = $.getUrlParam('picId');
     	console.log("getPicId:"+$id);

    } //----getAnncId()
    
   getPicId();
   getDataDetails($id);

   // 获取前一天图形
   $(".preday").unbind('click');
   $(".preday").bind('click',function(){

   		window.location.href = "details.html?picId="+($id-1);
   });

   $(".nextday").unbind('click');
   $(".nextday").bind('click',function(){

   		window.location.href = "details.html?picId="+($id*1+1);
   });
   function getDataDetails(id){
	   $.ajax({

			type:"get",
			url:"../web/getPictureById",
			data:"p_id="+id,
			datatype:"json",
			success:function(data){
				var data = eval(data);

				console.log(data);
			 
				if(data.code == '1'){

					var detail = '<div class="data-wrap"><div class="img-wrap"><img src="'+
								data.extend.picture.url+'"/></div><div class="introduction-wrap"><div class="type-name">'+
								data.extend.picture.typeName+'</div><hr><p class="tips"> 图形介绍：</p><div class="name">'+
								data.extend.picture.des+'</div><p class="tips">制作时间：</p><div class="create-time">'+
								data.extend.picture.creatTime+'</div></div></div>';

					$(".details-container").append(detail);

				}else{

					$(".details-container").append('<div class="notfindData">获取数据详细信息失败</div> ');
					
				}

			},error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

		});
	}


})