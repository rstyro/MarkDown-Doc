package top.lrshuai.doc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("top.lrshuai.doc.dao")
@EnableScheduling
public class Application{
	
	//只有登录才能查看文档
	public static final boolean IS_AUTH = false;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
