package com.lcz.register.utils;

import java.sql.Connection;
import java.sql.SQLException;

import cn.com.demo.javaweb.shopping.db.DaoUtils;

/**
 * 连接池版本的数据库连接管理工具类 适合于并发场合
 * 
 * @author LvChaoZhang
 *
 */
public class DbUtils {

	public static Connection getConnection() {
		return DaoUtils.getConn();

	}

	public static void rollback(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				// 将用过的连接归还到连接池中
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
