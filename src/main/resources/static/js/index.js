jQuery(document).ready(function($){
	$('.list ul li p').clickdown();
	$('.list-se p[class=title]').clickup();
	$('.list>ul>li').ad();
	
	$(".list .list-se li p").click(function(){
		$(".menu-active").removeClass("menu-active");
		$(this).addClass("menu-active");
	});
	
	changeLeftHeight();
	
	//下面是点击模态框显示
	$("#addParentDoc").click(function(){
		$('#addDocModal').modal("show")
	});
	$("#updateDoc").click(function(){
		getParentData("update")
		$('#updateDocModal').modal("show")
	});
	
	$("#addChildDoc").click(function(){
		getParentData("add")
		$('#addChildDocModal').modal("show")
	});
	$("#delDoc").click(function(){
		getParentData("del");
		$('#delDocModal').modal("show")
	});
	
	//添加分类
	$("#submitParentDoc").click(function(){
		submitAddDocData($("#parentName").val(),0,"");
	});
	
	//修改分类
	$("#submitUpdateDoc").click(function(){
		submitUpdateDocData($("#updateParentList").val(),$("#newName").val());
	});
	
	//添加接口
	$("#submitChildDoc").click(function(){
		submitAddDocData($("#docName").val(),$("#add_parentlist").val(),"");
	});
	
	//删除分类
	$("#submitDelDoc").click(function(){
		var ids="";
		if(confirm("删除此分类，该分类下的接口将一同删除，你确定要删除吗？")){
			$('input[name="ids"]:checked').each(function(){ 
				ids = ids + $(this).val()+",";
			});
			console.log("ids",ids); 
			submitDelDocData(ids);
		}
	});
	
	//搜索
	$("#menuSearch").click(function(){
		var keyword = $("input[name='keyword']").val();
		 top.location.href = _ctx+"/index?keyword="+keyword;
	});
});

$(window).resize(function(){
	changeLeftHeight();
	setIframeHeight(document.getElementById('mainFrame'));
});
//改变左边菜单的高度
function changeLeftHeight(){
	var wh  = $(window).height();
	$(".list").css("max-height",(wh-150)+"px");
}

//获取父分类数据
function getParentData(type){
	$.ajax({
		type:"get",
		url:_ctx+"/getParentDoc",
		cache:false,
		dataType:"json",
		data:{_t:new Date().getTime()},
		success:function(data){
			console.log("data",data);
			if(type == "add"){
				addParentEl(data.data,$("#add_parentlist"));
			}else if(type == "del"){
				addDelParentList(data.data);
			}else if(type == "update"){
				addParentEl(data.data,$("#updateParentList"));
			}
		}
	});
}
//添加子分类的父分类
function addParentEl(arr,el){
	var str = "";
	for(var i=0;i<arr.length;i++){
		str = str + "<option value='"+arr[i].id+"' >"+arr[i].name+"</option>";
	}
	el.empty();
	el.append(str);
}

//删除分类中的父分类
function addDelParentList(arr){
	var str = "";
	for(var i=0;i<arr.length;i++){
		str = str + "<p><input type='checkbox' name='ids' value='"+arr[i].id+"'> <span>"+arr[i].name+"</span></p>";
	}
	$("#parentDocList").empty();
	$("#parentDocList").append(str);
}
//修改分类
function submitUpdateDocData(id,name){
	console.log("newname",name);
	$.ajax({
		type:"post",
		url:_ctx+"/doc/update",
		cache:false,
		dataType:"json",
		data:{id:id,name:name,_t:new Date().getTime()},
		success:function(data){
			if(data.status == "success"){
				location.href=_ctx+"/index";
			}else{
				alert(data.msg);
			}
		}
	});
}

//添加分类请求
function submitAddDocData(name,parentId,content){
	$.ajax({
		type:"post",
		url:_ctx+"/doc/add",
		cache:false,
		dataType:"json",
		data:{name:name,parent_id:parentId,content:content,_t:new Date().getTime()},
		success:function(data){
			if(data.status == "success"){
				location.href=_ctx+"/index";
			}else{
				alert(data.msg);
			}
		}
	});
}

//删除分类请求
function submitDelDocData(ids){
	$.ajax({
		type:"post",
		url:_ctx+"/doc/del",
		cache:false,
		dataType:"json",
		data:{ids:ids,_t:new Date().getTime()},
		success:function(data){
			if(data.status == "success"){
				location.href=_ctx+"/index";
			}else{
				alert(data.msg);
			}
		}
	});
}