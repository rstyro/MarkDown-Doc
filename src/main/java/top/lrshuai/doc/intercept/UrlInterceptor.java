package top.lrshuai.doc.intercept;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import top.lrshuai.doc.Application;
import top.lrshuai.doc.util.Const;
import top.lrshuai.doc.util.ParameterMap;

public class UrlInterceptor implements HandlerInterceptor {

	private Logger log = Logger.getLogger(getClass());
	

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mv)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		HttpSession session = request.getSession();
		boolean isAuth = Application.IS_AUTH;
		if(isAuth){
			try {
				ParameterMap user = (ParameterMap) session.getAttribute(Const.USER_SESSION);
				if (null == user || "".equals(user)) {
					response.sendRedirect(request.getContextPath() + "/toLogin");
					return false;
				} 
			} catch (Exception e) {
				e.printStackTrace();
				log.error("error", e);
			}
		}
		return true;
	}

	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
