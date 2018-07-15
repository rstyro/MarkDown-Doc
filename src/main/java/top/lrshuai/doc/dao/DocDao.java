package top.lrshuai.doc.dao;

import java.util.List;

import top.lrshuai.doc.util.ParameterMap;

public interface DocDao {
	public List<ParameterMap> getDocs(ParameterMap pm);
	public ParameterMap getDocsDetail(ParameterMap pm);
	public int saveDoc(ParameterMap pm);
	public int updateDoc(ParameterMap pm);
	public int delDoc(ParameterMap pm);
	public int delMultiDoc(String[] ids);
	public void realDel();
}
