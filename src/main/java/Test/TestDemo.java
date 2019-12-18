package Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.demo.javaweb.shopping.dao.IUserDao;
import cn.com.demo.javaweb.shopping.entity.User;
import cn.com.demo.mvc.initailizer.SpringConfig;

@Component
public class TestDemo {
	private IUserDao userDao;

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	public void initApplicationContext() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
		userDao = ctx.getBean(IUserDao.class);
	}

	@Transactional
	@Test
	public void test05() {
		initApplicationContext();
		String money = "aa";
		User user = userDao.getUserById(1);
		userDao.addUser(user);
//		System.out.println(user);
		boolean falg = false;
		falg = userDao.payMoney(null, Integer.parseInt(money));
		System.out.println(falg);

	}

	@Test
	public void test04() {
		initApplicationContext();
		User user = userDao.getUserById(1);
		User user1 = userDao.getUser("13@qq.com", "123");
		System.out.println(user);
		System.out.println(userDao.isCheck("13@qq.com"));

	}

	@Test
	public void test03() throws Exception {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		try {
			IUserDao userDao = openSession.getMapper(IUserDao.class);
			User user = userDao.getUserById(1);
			System.out.println(user);
			System.out.println(userDao.payMoney(user, 20));
		} finally {
			openSession.close();
		}
	}
}
