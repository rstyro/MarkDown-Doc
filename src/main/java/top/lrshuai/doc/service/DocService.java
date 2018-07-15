package top.lrshuai.doc.service;

import java.util.Map;

import top.lrshuai.doc.util.ParameterMap;

public interface DocService {
	public ParameterMap findDoc(ParameterMap pm);
	public void saveDoc(ParameterMap pm);
	public void updateDoc(ParameterMap pm);
	public Map<String, Object> delDoc(ParameterMap pm);
	public Map<String, Object> delMultiDoc(ParameterMap pm);
}
