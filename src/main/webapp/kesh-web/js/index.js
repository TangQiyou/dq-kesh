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

	// $(".content-wrap").waterfall({
	//     itemClass: ".data-wrap",
	//     minColCount: 2,
	//     spacingHeight: 10,
	//     resizeable: true,
				
				
	//     ajaxCallback: function(success, end) {
	//         var data = {"data": [
	//             { "src": "3.jpg" }, { "src": "4.jpg" }, { "src": "2.jpg" }, { "src": "5.jpg" }, { "src": "1.jpg" }, { "src": "6.jpg" }
	//         ]};
	//         var str = "";
	//         var templ = '<div class="data-wrap"><div class="img-wrap"><img src="demo图片/{{src}}"/></div>'+
	//         			'<div class="introduction-wrap"><div class="type-name">降水</div><hr>'+
	// 					'<div class="name">成都信息工程大学降水量数据图</div><div class="create-time">'+
	// 					'2017-10-22</div></div></div>';

	//         for(var i = 0; i < data.data.length; i++) {
	//             str += templ.replace("{{src}}", data.data[i].src);
	//             console.log(i);
	//         }
	//         $(str).appendTo($(".content-wrap"));
	//         success();
	//         end();
	//     }
	// });

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

	  

})