$(document).ready(function(){
//登陆检测是否为空

//密码不能为空
//记住密码需要的之后再调
//检测用户是否为空，传值给后台，匹配相同的用户
	$(".user-name").blur(function(){
		var user_name = $.trim($(".user-name").val());//获得用户名的值
		//用户名不能为空
		if (user_name =="") {
			 $(".user-lack").css('display','block');
			$(".user").css('display','none');
		}else{
			 $(".user-lack").css('display','none'); 
			 //$(".user").css('display','none');
			 }
	});
			// $.ajax({
			// 	url : '',
			// 	type : "POST",
			// 	success : function(data){
			// 		var getData = eval(data);
			// 		if (getData.success) {
			// 			// alert("该用户名已存在");
			// 			// $(".user-error").css('display','block'); 
			// 			// 要看后台的定义，success的定义是什么
			// 			$(".user-name").focus();
			// 		}else{
			// 		}
				// }
			// });
	
	$(".js-pass-code").blur(function(){
		var  passwordVal = $.trim($(".js-pass-code").val());
		if (passwordVal =="") {
			// alert("该用户名已存在");
			$(".pass-lack").css('display','block');
			// $(".pass").css('display','none');
		}else{
			 $(".pass-lack").css('display','none'); 
			 $(".pass").css('display','none');
			 }
	});
	$(".js-sub").click(function(){
		// alert("该用户名已存在");
		var user_name = $.trim($(".user-name").val()),//从用户名中取值
		    passwordVal = $.trim($(".js-pass-code").val())
		if (user_name == "") {
			$(".user").css('display','block'); 
			$(".user-name").focus();
			return false;
		}else if (passwordVal == "") {			
			$(".pass").css('display','block'); 
			$(".js-pass-code").focus();
			return false;
		}
	});
});