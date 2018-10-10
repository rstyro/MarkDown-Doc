package top.lrshuai.doc.service;

import java.util.List;
import java.util.Map;

import top.lrshuai.doc.util.ParameterMap;

public interface IndexService {
	public List<ParameterMap> getDocs(ParameterMap pm);
	
	public Map<String, Object> getParentDoc(ParameterMap pm);
}
