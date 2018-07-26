package top.lrshuai.doc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lrshuai.doc.dao.DocDao;
import top.lrshuai.doc.service.IndexService;
import top.lrshuai.doc.util.ParameterMap;
import top.lrshuai.doc.util.ReturnModel;
import top.lrshuai.doc.util.Tools;

@Service
public class IndexServiceImpl implements IndexService{
	
	@Autowired
	private DocDao docDao;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public List<ParameterMap> getDocs(ParameterMap pm) {
		pm.put("doc_id", "0");
		List<ParameterMap> docsList = docDao.getDocs(pm);
		if(docsList != null){
			for(ParameterMap doc:docsList){
				doc.put("doc_id", doc.getString("id"));
				if(!Tools.isEmpty(pm.getString("keyword"))){
					doc.put("keyword", pm.getString("keyword"));
				}
				List<ParameterMap> secondDocs = docDao.getDocs(doc);
				if(secondDocs != null){
					doc.put("seconds", secondDocs);
				}else{
					doc.put("seconds", new ArrayList<>());
				}
			}
		}else{
			docsList = new ArrayList<>();
		}
		return docsList;
	}
	
	@Override
	public Map<String, Object> getParentDoc() {
		List<ParameterMap> docsList = null;
		try {
			ParameterMap pm = new ParameterMap();
			pm.put("doc_id", "0");
			docsList = docDao.getDocs(pm);
			if(docsList == null){
				docsList = new ArrayList<>();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("get Data error", e);
			return ReturnModel.getModel("获取数据异常", "failed", null);
		}
		return ReturnModel.getModel("ok", "success", docsList);
	}
}
