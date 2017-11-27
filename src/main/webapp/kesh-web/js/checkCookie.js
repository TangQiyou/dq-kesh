function getCurrentTime(){

	    var mydate = new Date();
	    var now = "" + mydate.getFullYear() + "年";
	    now += (mydate.getMonth()+1) + "月";
	    now += mydate.getDate() + "日";
	    return now;
   }
   
function GetRequest() {
  
  var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}
function setCookie(c_name,value)
{
	var exdate=new Date();
//	exdate.setDate(exdate.getDate()+expiredays);

	document.cookie=c_name+ "=" +escape(value);
};

function getCookie(c_name)
{
	if (document.cookie.length>0)
	  {
	  	c_start=document.cookie.indexOf(c_name + "=");

		  	if (c_start!=-1)
		    { 
			    c_start=c_start + c_name.length+1 ;
			    c_end=document.cookie.indexOf(";",c_start);

			    if (c_end==-1) c_end=document.cookie.length;

			    return unescape(document.cookie.substring(c_start,c_end));
		    } 
	  }
	return "";
}

function delCookie(name){//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间   
    var date = new Date();   
    date.setTime(date.getTime() - 10000);   
    document.cookie = name + "=a; expires=" + date.toGMTString();   
}  

function checkCookie(el)
{
	userid=getCookie('userid');
	
	if (userid!=null && userid!="")
	  {
	  	console.log($(el).text());
	  	if($(el).text() == "个人"){
			location.href = "personal.html";
		}
	  	
	  }
	else 
	  {
	  	swal({
				title:"你还没有登录，请登录后再进入",
				text:"正在前往登录页面",
				type:"warning",
				showConfirmButton: true
				},function(){

				location.href = "login.html";

			});

	  }
}

// 获取各种selects
	function getSelects(){

		$.ajax({
			type:"get",
			url:"../public/getSelects",
			dataType: "json",
			success:function(data){
				var data = eval(data);

				// 添加学院option
				$.each(data.extend.collegeList,function(i,option){

					$("select[name='college']").append("<option value='"+option.codeValue+"'>"+option.codeName+"</option>");
				
				});

				// 添加身份option
				$.each(data.extend.statusList,function(i,option){

					$("select[name='status']").append("<option value='"+option.codeValue+"'>"+option.codeName+"</option>");
				
				});
				
			}
		})
	}