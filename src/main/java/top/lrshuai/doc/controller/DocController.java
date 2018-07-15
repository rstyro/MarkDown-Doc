package top.lrshuai.doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.lrshuai.doc.controller.base.BaseController;
import top.lrshuai.doc.service.DocService;
import top.lrshuai.doc.util.Const;
import top.lrshuai.doc.util.DateUtil;
import top.lrshuai.doc.util.ParameterMap;
import top.lrshuai.doc.util.ReturnModel;

@Controller
@RequestMapping("/doc")
public class DocController extends BaseController{

	
	@Autowired
	private DocService docService;
	
	@GetMapping("/{id}")
	public String detail(@PathVariable String id,Model model){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		pm.put("id", id);
		model.addAttribute("doc", docService.findDoc(pm));
		return "page/doc";
	}
	
	
	@PostMapping("/add")
	@ResponseBody
	public Object add(){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		ParameterMap user = (ParameterMap) getSession().getAttribute(Const.USER_SESSION);
		if(user == null)return ReturnModel.getNotAuthModel();
		pm.put("user_id", user.getString("user_id"));
		System.out.println("pm="+pm);
		try {
			pm.put("create_time", DateUtil.getTime());
			docService.saveDoc(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("保存文档", e);
			return ReturnModel.getModel("保存时失败", "failed", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable String id,Model model){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		pm.put("id", id);
		model.addAttribute("doc", docService.findDoc(pm));
		model.addAttribute("btn_name", "更新");
		return "page/edit";
	}
	
	@PostMapping("/update")
	@ResponseBody
	public Object updateDoc(){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		System.out.println("pm="+pm);
		try {
			docService.updateDoc(pm);
		} catch (Exception e) {
			return ReturnModel.getErrorModel("更新错误");
		}
		return ReturnModel.getSuccessModel();
	}
	
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable String id,Model model){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		pm.put("id", id);
		docService.updateDoc(pm);
		model.addAttribute("doc", docService.findDoc(pm));
		model.addAttribute("btn_name", "更新");
		return "page/doc";
	}
	
	
	@PostMapping("/del")
	@ResponseBody
	public Object delAll(){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		return docService.delMultiDoc(pm);
	}
	
	@PostMapping("/del/{id}")
	@ResponseBody
	public Object del(@PathVariable String id){
		log.info("访问详情");
		ParameterMap pm = this.getParameterMap();
		pm.put("id", id);
		return docService.delDoc(pm);
	}
}
