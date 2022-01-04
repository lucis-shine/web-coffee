function addOrRemoveCollects(){
	//当前是否登录了
	if($("#user").val()==null || ''==$("#user").val()){
		location.href=path+"/before/user/login.jsp";
		return;
	}
	var collects = new Object();
	collects.coffeeid = $("#coffeeid").val();
	collects.m = "addOrRemove";
	console.log(collects);
	$.ajax({
		//请求方式  同步 false  异步true
        async:true,
        //请求方式
        type : "POST",
        //请求地址
        url : path+"/filter/before/collects",
        //数据，json字符串,
        //返回值的类型
        dataType: "text",
        data : collects,
        //请求成功
        success : function(result) {
            console.log(result+path);
            if('remove'==$.trim(result)){
            	//移除   原来是收藏颜色      变为未收藏颜色
            	//把当前的样式进行切换
            	$("#collectsArea").removeClass("sc_css_active");
            	$("#collectsArea").addClass("sc_css");
            	$("#collectsArea").blur();//失去鼠标焦点
            }else if('add'==$.trim(result)){//添加  原来是未收藏颜色    变为收藏的颜色
            	$("#collectsArea").removeClass("sc_css");
            	$("#collectsArea").addClass("sc_css_active");
            	$("#collectsArea").blur();//失去鼠标焦点
            }
            console.log(path);
        },
        //请求失败，包含具体的错误信息
        error : function(e){
            console.log(e.status);
            console.log(e.responseText);
        }
	});
}



function addComments(coffeeid){
	var content = $("#commentsContent").val();
	alert("coffeeid="+coffeeid);
	alert("content="+content);
	location.href=path+"/filter/before/comments?m=add&coffeeid="+coffeeid+"&content="+content;
}