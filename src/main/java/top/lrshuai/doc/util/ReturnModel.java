package top.lrshuai.doc.util;

import java.util.HashMap;


public class ReturnModel{

	private static HashMap<String,Object> model=null;
	
	private ReturnModel() {}
	
	public static HashMap<String, Object> getModel(String msg,String status,Object data){
		if(model == null){
			model = new HashMap<>();
		}
		if(Tools.notEmpty(msg)){
			model.put("msg", msg);
		}
		if(Tools.notEmpty(status)){
			model.put("status", status);
		}
		if(data != null){
			model.put("data", data);
		}else{
			model.put("data", null);
		}
		return model;
	}
	public static HashMap<String, Object> getModel(String msg,String status,Object data,ParameterMap page){
		if(model == null){
			model = new HashMap<>();
		}
		if(Tools.notEmpty(msg)){
			model.put("msg", msg);
		}
		if(Tools.notEmpty(status)){
			model.put("status", status);
		}
		if(data != null){
			model.put("data", data);
		}else{
			model.put("data", null);
		}
		if(page != null){
			model.put("page", page);
		}else{
			model.put("page", null);
		}
		return model;
	}
	
	public static HashMap<String, Object> getSuccessModel(){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "success");
		model.put("msg", "ok");
		return model;
	}
	
	public static HashMap<String, Object> getParameErrorModel(){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "failed");
		model.put("msg", "你请求的是一个冒牌接口");
		return model;
	}
	
	public static HashMap<String, Object> getErrorModel(String... msg){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "failed");
		model.put("msg", "错误");
		if(msg != null && !"".equals(msg))
			model.put("msg", msg);
		return model;
	}
	public static HashMap<String, Object> getNotAuthModel(){
		if(model == null){
			model = new HashMap<>();
		}
		model.put("status", "notauth");
		model.put("msg", "你权限不足");
		return model;
	}
}
