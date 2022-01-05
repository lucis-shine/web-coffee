$(document).ready(function() {
	// 手机号码验证
	jQuery.validator.addMethod("isPhone", function(value, element) {
		var length = value.length;
		return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/.test(value));
	}, "请正确填写您的手机号码。");

	$("#add-form").validate({
		errorElement : 'span',
		errorClass : 'help-block',
		rules : {
			addressname : {
				required : true
			},
			phone : {
				required : true,
				isPhone : true
			},
			linkman : {
				minlength : 2
			}
		},
		messages : {
			addressname : {
				required : "请输入地址名称"
			},
			phone : {
				required : "请输入手机号码"
			},
			linkman : {
				required : "请输入联系人",
				minlength : jQuery.format("联系人不能少于{0}个字符")
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
			var address = new Object();
			address.addressname = $("#addressname").val();
			address.phone = $("#phone").val();
			address.linkman = $("#linkman").val();
			address.m = "add";
			console.log(address);
			$.ajax({
				//请求方式  同步 false  异步true
		        async:true,
		        //请求方式
		        type : "POST",
		        //请求地址
		        url : path+"/filter/before/address",
		        //数据，json字符串,
		        //返回值的类型
		        dataType: "json",
		        data : address,
		        //请求成功
		        success : function(result) {
		            console.log(result);
		            if('true'==$.trim(result)){
		            	location.href=path+'/filter/before/address?m=list';//跳转到查看地址列表页面
		            }else{
		            	$("#resultInfo").text("修改失败");
		            	$("#resultInfo").css("color","red");
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