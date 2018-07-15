package top.lrshuai.doc.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import top.lrshuai.doc.util.ParameterMap;

public interface UserService {
	public Map<String,Object> login(ParameterMap pm,HttpSession session);
}
