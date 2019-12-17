package cn.com.demo.mvc.initailizer;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:db.properties", encoding = "utf-8")
@MapperScan("cn.com.demo.javaweb.shopping.dao")
public class MyBatisConfig implements EnvironmentAware {
	@Value("${jdbc.driverName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.userName}")
	private String username;
	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource createDataSource() {
		BasicDataSource bds = new BasicDataSource();
		if (this.driverClassName == null || this.url == null || this.username == null || this.password == null) {
			this.driverClassName = this.env.getProperty("jdbc.driverName");
			this.url = this.env.getProperty("jdbc.url");
			this.username = this.env.getProperty("jdbc.userName");
			this.password = this.env.getProperty("jdbc.password");
		}
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
		return bds;
	}

	@Bean("sqlSessionFactoryBean")
	public SqlSessionFactoryBean createSqlSessionFactory(@Autowired DataSource ds) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		return factoryBean;
	}

//	//@Bean
//	public MapperScannerConfigurer createMapperScannerConfigurer() {
//		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//		configurer.setBasePackage("cn.com.ssm.shopping.mapper");
//		configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//		return configurer;
//	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}

	private Environment env;
}
