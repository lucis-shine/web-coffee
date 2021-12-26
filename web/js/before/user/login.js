$(document).ready(function() {
	$("#login-form").validate({
		errorElement : 'span',
		errorClass : 'help-block',

		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : "请输入用户名",
			password : {
				required : "请输入密码"
			}
		},
		//跟一个函数，可以自定义错误放到哪里。
		errorPlacement : function(error, element) {
			element.next().remove();
			element.after('<span class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
			element.closest('.form-group').append(error);
		},
		//可以给未通过验证的元素加效果、闪烁等。
		highlight : function(element) {
			$(element).closest('.form-group').addClass('has-error has-feedback');
		},
		success : function(label) {
			var el=label.closest('.form-group').find("input");
			el.next().remove();
			el.after('<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
			label.closest('.form-group').removeClass('has-error').addClass("has-feedback has-success");
			label.remove();
		},
		//成功后调用的资源
		submitHandler: function(form) { 
			var user = new Object();
			user.username = $("#username").val();
			user.password = $("#password").val();
			user.m = "login";
			console.log(user);
			$.ajax({
				//请求方式  同步 false  异步true
		        async:true,
		        //请求方式
		        type : "POST",
		        //请求地址
		        url : path+"/before/user",
		        //数据，json字符串,
		        //返回值的类型
		        dataType: "json",
		        data : user,
		        //请求成功
		        success : function(result) {
		            console.log(result);
		            if('true'==$.trim(result)){
		            	//跳转到主页
		            	location.href=path+'/before/browseIndex?m=index';
		            }else{
		            	//登录失败
		            	$("#resultInfo").text("登录失败");
		            	$("#resultInfo").css("color","red");
		            	$("#resultInfo").css("font-weight","bold");
		            }
		        },
		        //请求失败，包含具体的错误信息
		        error : function(e){
		            console.log(e.status);
		            console.log(e.responseText);
		        }

			});
		}

	});
});