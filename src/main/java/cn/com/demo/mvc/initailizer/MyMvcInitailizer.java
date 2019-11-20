package cn.com.demo.mvc.initailizer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyMvcInitailizer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;// spring容器的配置类
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringMVCConfig.class};// web容器的配置类
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}
