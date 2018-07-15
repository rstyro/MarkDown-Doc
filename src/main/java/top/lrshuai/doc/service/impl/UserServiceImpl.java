package top.lrshuai.doc.service.impl;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lrshuai.doc.dao.UserDao;
import top.lrshuai.doc.service.UserService;
import top.lrshuai.doc.util.Const;
import top.lrshuai.doc.util.ParameterMap;
import top.lrshuai.doc.util.ReturnModel;
import top.lrshuai.doc.util.SHA;
import top.lrshuai.doc.util.Tools;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Override
	public Map<String, Object> login(ParameterMap pm,HttpSession session) {
		try {
			String psw = pm.getString("password");
			String userName = pm.getString("username");
			if(Tools.isEmpty(userName) || Tools.isEmpty(psw)){
				return ReturnModel.getModel("你请求的是冒牌接口", "falied", null);
			}
			psw = SHA.encryptSHA(psw);
			System.out.println("encode psw=" + psw);
			pm.put("password", psw);
			ParameterMap user = userDao.getUserInfo(pm);
			if (user == null) {
				return ReturnModel.getModel("用户名或密码错误", "failed", null);
			}
			if(user.getString("lock").equals("1")){
				return ReturnModel.getModel("您的账号已锁定", "failed", null);
			}
			session.setAttribute(Const.USER_SESSION, user);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("login error :" + e.getMessage(), e);
			return ReturnModel.getModel("登录错误，请稍后重试", "failed", null);
		}
		return ReturnModel.getModel("ok", "success", null);
	}
}
