package top.lrshuai.doc.intercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorAdapter extends WebMvcConfigurerAdapter {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UrlInterceptor()).addPathPatterns("/**")
				.excludePathPatterns("/toLogin","/user/login","/error/**");
		super.addInterceptors(registry);
	}
}
