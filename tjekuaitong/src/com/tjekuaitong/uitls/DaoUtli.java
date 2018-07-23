package com.tjekuaitong.uitls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtli {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tjekuaitong", "root", "root");

		} catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection con){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
