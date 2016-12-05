package com.mustache.webservice;

import com.mustache.webservice.security.CustomUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;
import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan
@EnableWebMvc
//@EnableConfigurationProperties(MybatisProperties.class)
@Slf4j
@MapperScan(value = ("com.mustache.webservice"))
public class DemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.web(true);
		return builder.sources(DemoApplication.class);
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:query/*.xml");
		System.out.println("DEBUG : SQL MAPPER LENGTH : " + resources.length);
		sessionFactory.setMapperLocations(resources);
		sessionFactory.setTypeAliasesPackage("com.mustache.webservice");

		Configuration config = new Configuration();
		config.setMapUnderscoreToCamelCase(true);
		sessionFactory.setConfiguration(config);

		return sessionFactory.getObject();
	}

	//세션 관리를 위한 리스너
	@Bean
	public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
		return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
