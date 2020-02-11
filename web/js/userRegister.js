$(document).ready(function(){
//检测用户，用户不能为空，不能重复
	$(".user-name").blur(function(){
		var user_name = $.trim($(".user-name").val());
		if (user_name =="") {
			// alert("请输入用户名");
			// $(".user-block").show();
			$(".user-lack").css('display','block');//请输入用户名
			$(".user").css('display','block');
			// $(".user-name").focus();
		}else{//不为空时
			 $(".user-lack").css('display','none'); 
			 // $(".user").css('display','none'); 
			 $.ajax({
				 type: "POST",
			 	 url: '/WLSYS/UserReg',
				 data: $(this).val(),
		//	 	 success : function(data){
		//	 	 	//不存在为真，存在为假
		//	 	 	var getData = eval(data);
		//	 	 	if (!getData.success){
		//	 		// if (data=="false") {
		//				$(".user-error").css('display','block');//显示该用户名已存在
		//	 			/*$(".user-name").focus();*/
		//	 		}else{
		//				$(".user-error").css('display','none');
		//				// $(".user-success").css('display','block');
		//	 		}
		//	 	 },
		//		 error: function(){
		//		 },
		  success : function(data){
			  		if (data=="false") {
			 			$(".user-error").css('display','block');
			  			/*$(".user-name").focus();*/
			  		}else{
			 			$(".user-error").css('display','none');
			 			$(".user-success").css('display','block');
			  		}
			  	 },
			 	 error: function(){
			 	 },
			 });
		}
		// 	success : function(data){
			// 		var getData = eval(data);
			// 		if (getData.success) {
			// 			// alert("该用户名已存在");
			// 			// $(".user-error").css('display','block'); 
			// 			// 要看后台的定义，success的定义是什么
			// 			$(".user-name").focus();
			// 		}else{
			// 		}
			// 	}
	});
//检测密码，符合输入格式
	$(".js-pass-code").blur(function(){
		var passwordVal = $.trim($(this).val());
		var bool = checkPs(passwordVal);
		if (!bool) {
			// alert("密码为4-16位数字、字母组合");
			$(".pass-error").css('display','block');
			$(".pass").css('display','none');
			// $(".js-pass-code").focus();
		}else{
			$(".pass-error").css('display','none'); 
			$(".pass").css('display','none');
			// $(".js-pass-code").focus();
		}
	});
	
//检测确认密码，
	$(".u-code").blur(function(){
		var u_code = $.trim($(this).val()),
		 	passwordVal = $.trim($(".js-pass-code").val());
		if (u_code !== passwordVal ) {//如果u-code
			// && u_code!=""
			$(".u-code-error").css('display','block');
			$(".u").css('display','none');
			// $(".u-code").focus();
		}else{
			$(".u-code-error").css('display','none');
			$(".u").css('display','none');  
			// $(".u-code").focus();
		}
	});
	
	//检测手机号
	$(".mobile").blur(function(){
		var mobile_val = $.trim($(this).val());
		var bool = checkMobile(mobile_val);
		if(!bool){
			$(".mobile-error").css('display','block');
			$(".number").css('display','none');
		}else{
			$(".mobile-error").css('display','none');
			$(".number").css('display','none');
		}
	});
	
	//验证码不为空
	$("#code").on("blur",function(){
		var code = $(this).val();
		if(code == ""){
			$(".error-code").css('display','block');
			$(".vcode").css('display','none');
		}else{
			$(".error-code").css('display','none');
			$(".success-code").css('display','block');
		}
	});

//总体的验证
//我想可以调用一下函数，再进行好的用户体验
	$(".js-sub").click(function(){
		var codeval = $.trim($("#code").val()),
			user_name = $.trim($(".user-name").val()),
			passwordVal = $.trim($(".js-pass-code").val()),
			u_code = $.trim($(".u-code").val()),
			mobile_val = $.trim($(".mobile").val());
		if (user_name == "") {
			$(".user").css('display','block'); 
			$(".user-name").focus();
			return false;
		}else if (passwordVal == "") {			
			$(".pass").css('display','block'); 
			$(".js-pass-code").focus();
			return false;
		}else if (u_code == "") {
			$(".u").css('display','block'); 
		    $(".u-code").focus();
			return false;
		}else if (mobile_val == "") {
			$(".number").css('display','block'); 
			$(".mobile").focus();
			return false;
		}else if (codeval == "") {
			$(".vcode").css('display','block');
			$("#code").focus();
			return false;
		}
		//验证码验证
		var obj = $(this);
		$.ajax({
			url:'WLSYS/servlet/CodeServlet',
			type:'POST',
			data:{code:$.trim($("input[name=code]").val())},
			dataType:'json',
			async:false,
			success:function(result) {
				if(result.status == 1) {
					obj.parents('form').submit(); //验证码正确提交表单
				}else{
					$(".code-img").click();
					$(".yzmtips").html('验证码错误！');
					setTimeout(function(){
						$(".yzmtips").empty();
					},3000);
				}
			},
			error:function(msg){
				$(".yzmtips").html('Error:'+msg.toSource());
			}
		})
		return false;
	});
/**
 * 检测用户密码
 * @param  {[type]} str [description]
 * @return {[type]}     [description]
 */
function checkPs(str){
	//正则有问题：;
    var re = /^[a-zA-z0-9]\w{3,15}$/;
    if(re.test(str)){
        return true;
    }else{
        return false;
    }          
}

/**
 * 检测手机号
 * @param  {[type]} str [description]
 * @return {[type]}     [description]
 */
function checkMobile(str) {
    var re = /^1\d{10}$/
    if (re.test(str)) {
        return true;
    } else {
        return false;
    }
}

	function changeValidateCode(){
		$.ajax({
			type: 'post',
			url: WLSYS/servlet/CodeServlet,
			data: $("img").text(),
			success:function(data){
				result = $("img").eval();
				if(!result.success){
					alert("msg");
				}else{
					$("img").show();
				}
			},
			error:function(){
			}
		});
	}
});





