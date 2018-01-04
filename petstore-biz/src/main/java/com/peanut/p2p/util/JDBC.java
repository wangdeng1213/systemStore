package com.peanut.p2p.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {	
	public static Connection conn ;
	/** 
	 * 得到数据库连接
	 */
	public static Connection getConn(){
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.203:3306/ssgx";
		String user = "root";
		String password = "root";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}

	//public static
	/**
	 * 关闭数据库
	 */
	public static void close(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
