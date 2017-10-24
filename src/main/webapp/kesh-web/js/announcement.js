$(window).ready(function(){

	var $id;
    function getAnncId(){

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
     
	   	$id = $.getUrlParam('annId');
     	console.log("getAnncId:"+$id);

    } //----getAnncId()
    
   getAnncId();
    
    if($id == "more"){
    	$.ajax({
    		type:"get",
			url:"../web/announcements2",
			data:"pn="+1,
			datatype:"json",
    		success:function(data){
    			var data = eval(data);
    			console.log(data.extend.pageInfo.list);
    			if(data.code == '1'){

    				$(".all-annc").after('<ul class="acc-list"></ul>');
    				$.each(data.extend.pageInfo.list,function(i,acc){
    				
	    				var list = "<li><a href='announcement.html?annId="+acc.annId
								+"')>"+acc.annTitle+"</a></li>"
	    				$(".acc-list").append(list);
    				});
    			}else{

    				$(".all-annc").after('<ul class="acc-list"><li><a href="#">暂无公告</a></li></ul>');
    			}

    		},error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}

    	});
    }else{
    	
    	getAnncById($id);
    }
    
    // 根据ID获取指定公告详情
	function getAnncById($id){

		$.ajax({
			type:"get",
			datatype:"json",
			url:"../web/announcement",
			data:"a_id="+$id,
			success: function(data){
				var data = eval(data);
				console.log(data);

				if(data.code == '1'){
					$(".all-annc").after('<div class="annc-wrap"><div class="annc-title">'+
						data.extend.announcement.annTitle+'</div><div class="annc-detail">'+
						data.extend.announcement.annContent+'</div><div class="annc-time">'+
						data.extend.announcement.annTime+'</div></div>');
				}else{
					$(".all-annc").after('<div class="annc-wrap"><div class="annc-title">'+
						'查询详细公告信息失败'+'</div></div>');
				}
				
			
			},
			error:function(jqXHR, textStatus, errorThrown){
				 console.log(jqXHR);
				 console.log(errorThrown);
				 console.log(textStatus);
			}
		})
	}
	


})