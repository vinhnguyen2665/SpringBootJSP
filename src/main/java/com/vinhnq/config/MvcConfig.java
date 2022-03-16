package com.vinhnq.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "vn.com.nsmv.controller" })
public class MvcConfig implements WebMvcConfigurer {
	

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/index.html").addResourceLocations("/WEB-INF/view/react-app/build/index.html");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/pages/");
		bean.setSuffix(".jsp");
		return bean;
	}

	/*
	 * messageSource bean is spring built-in bean name which will manipulate
	 * internationalization messages. All message files is saved in
	 * src/main/resources/config/ folder, if the config folder do not exist, you
	 * need to create it first by hand. Each message file is a properties file, the
	 * file base name is messages and suffix with the language or country ISO code,
	 * such as messages_en, messages_zh_cn etc.
	 */
	@Bean(name = "messageSource")
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource ret = new ReloadableResourceBundleMessageSource();

		// Set the base name for the messages properties file.
		ret.setBasename("classpath:/messages");

		ret.setCacheSeconds(1);

		ret.setUseCodeAsDefaultMessage(true);

		ret.setDefaultEncoding("utf-8");

		return ret;
	}
	@Bean(name = "localeResolver")
	public LocaleResolver getLocaleResolver()  {
//		CookieLocaleResolver resolver= new CookieLocaleResolver();
//		resolver.setCookieDomain(CommonConst.SYSTEM.NAME.replaceAll(" ", "") + "Cookie");
//		// 60 minutes
//		resolver.setCookieMaxAge(60*60);
		LocaleResolver resolver = new UrlLocaleResolver();
//		((UrlLocaleResolver) resolver).setCookieDomain(CommonConst.SYSTEM.NAME.replaceAll(" ", "") + "Cookie");
//		// 60 minutes
//		((UrlLocaleResolver) resolver).setCookieMaxAge(60*60);
		return resolver;
	}

	@Bean(name = "messageSource")
	public MessageSource getMessageResource()  {
		ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();

		// Read i18n/messages_xxx.properties file.
		// For example: i18n/messages_en.properties
		messageResource.setBasename("classpath:i18n/messages");
		messageResource.setDefaultEncoding("UTF-8");
		return messageResource;
	}
	@Bean(name = "localeInterceptor")
	public LocaleChangeInterceptor getLocaleInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}

	/*
	 * Also need to register above locale interceptor in spring then it will
	 * intercept user request url and parse out the lang query string to get user
	 * request locale.
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
		registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/vi/*");
		//registry.addInterceptor(getLocaleInterceptor());
	}
}
