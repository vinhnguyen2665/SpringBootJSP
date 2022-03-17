package com.vinhnq.config;

import com.vinhnq.common.CommonConst;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.vinhnq.repository",
		entityManagerFactoryRef = CommonConst.CONFIG.JPAEntityManagerFactory,
		transactionManagerRef= CommonConst.CONFIG.JPATransactionManager
)
public class JPAConfig {

	private final Environment env;

	public JPAConfig(Environment env) {
		this.env = env;
	}

	//@Bean
	@Bean(name = CommonConst.CONFIG.JPADataSource)
	@Primary
	//@ConfigurationProperties(prefix="datasource.primary")
	public DataSource getJPADataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}

	@Autowired
	@Primary
	@Bean(name = CommonConst.CONFIG.JPAEntityManagerFactory)
	public SessionFactory getSessionFactory(@Qualifier(CommonConst.CONFIG.JPADataSource) DataSource dataSource) throws Exception {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("current_session_context_class", //
				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		// Package contain entity classes
		factoryBean.setPackagesToScan("com.vinhnq.entity");
		factoryBean.setDataSource(dataSource);
		factoryBean.setHibernateProperties(properties);
		factoryBean.afterPropertiesSet();
		//
		SessionFactory sf = factoryBean.getObject();
		System.out.println("## getSessionFactory: " + sf);
		return sf;
	}


	@Autowired
	@Primary
	@Bean(name = CommonConst.CONFIG.JPATransactionManager)
	public HibernateTransactionManager getTransactionManager(@Qualifier(CommonConst.CONFIG.JPAEntityManagerFactory)SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
}
