package com.myproject.conection;
import java.sql.*;

public class JDBCConnection {
	public static void main(String[] args) throws SQLException{
		
		final String dbURL = "jdbc:sqlserver://localhost;databaseName=managestu;user=sa;password=tuannguyen123";
	    final Connection conn = DriverManager.getConnection(dbURL);
	    final Statement st = conn.createStatement();
	    ResultSet resultSet = null;
//		try {
//		    Students student = new Students();
//			
//			System.out.println("Nhập thông tin sinh viên");
//			student.inputST();
//	            st.executeUpdate("INSERT INTO campus (username,password,email,fullname,gender,address,level)" + 
//	                "VALUES ('"+ student.getUsername() +"', '"+ student.getPassword() +"', '"+ student.getEmail() +"',"
//	                		+ "'"+ student.getFullname() +"', '"+ student.getGender() +"', '"+ student.getAddress() +"', '"+ student.getLevel() +"')"); 
//	            System.out.println("Đã thêm dữ liệu");
//		   } catch (SQLException ex) {
//		     System.err.println("Cannot connect database, " + ex.getMessage());
//		   }
		System.out.println("In thông tin đã nhập ----------- ");
		resultSet = st.executeQuery("Select * from campus");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1) + ". " + " " + resultSet.getString(2)+ " " + resultSet.getString(3)
			+ " "+ resultSet.getString(4)+ " " + resultSet.getString(5)+ " " + resultSet.getString(6)+ " " + resultSet.getString(7));
		}
	conn.close();
	}
}
