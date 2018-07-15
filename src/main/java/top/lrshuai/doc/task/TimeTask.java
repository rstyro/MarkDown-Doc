package top.lrshuai.doc.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import top.lrshuai.doc.dao.DocDao;

@Component
public class TimeTask {

	@Autowired
	private DocDao docDao;
	
	private Logger log = Logger.getLogger(getClass());
	
	/**
	 * 没周一执行
	 */
	@Scheduled(cron = "0 0 0 ? * MON")  
    public void delDocTask() {  
        try {
        	docDao.realDel();
        	log.info("执行 真实删除操作");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("执行真实删除操作失败", e);
		}
    } 
}
