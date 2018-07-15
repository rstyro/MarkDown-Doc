package top.lrshuai.doc.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lrshuai.doc.dao.DocDao;
import top.lrshuai.doc.service.DocService;
import top.lrshuai.doc.util.ParameterMap;
import top.lrshuai.doc.util.ReturnModel;

@Service
public class DocServiceImpl implements DocService{

	@Autowired
	private DocDao docDao;
	
	private Logger log  = Logger.getLogger(this.getClass());
	
	@Override
	public ParameterMap findDoc(ParameterMap pm) {
		return docDao.getDocsDetail(pm);
	}

	@Override
	public void saveDoc(ParameterMap pm) {
		try {
			docDao.saveDoc(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("save error", e);
		}
	}
	
	@Override
	public void updateDoc(ParameterMap pm) {
		try {
			docDao.updateDoc(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("update error", e);
		}
	}

	@Override
	public Map<String, Object> delDoc(ParameterMap pm) {
		try {
			docDao.delDoc(pm);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("update error", e);
			return ReturnModel.getErrorModel("删除错误");
		}
		return ReturnModel.getSuccessModel();
	}
	
	@Override
	public Map<String, Object> delMultiDoc(ParameterMap pm) {
		try {
			String idsString = pm.getString("ids");
			String[] ids = idsString.split(",");
			docDao.delMultiDoc(ids);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("update error", e);
			return ReturnModel.getErrorModel("删除错误");
		}
		return ReturnModel.getSuccessModel();
	}
	
}
