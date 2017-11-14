function getCurrentTime(){

	    var mydate = new Date();
	    var now = "" + mydate.getFullYear() + "年";
	    now += (mydate.getMonth()+1) + "月";
	    now += mydate.getDate() + "日";
	    return now;
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