package com.gdustudent.v1;

import java.sql.*;

public class KetNoiCSDL {
	final String dbURL;
	final Connection connection;
	final Statement st;

	public KetNoiCSDL() throws SQLException {
		this.dbURL = "jdbc:sqlserver://localhost;databaseName=gduStudents;user=sa;password=tuannguyen123;";
		this.connection = DriverManager.getConnection(dbURL);
		this.st = connection.createStatement();
	}

	protected String getDbURL() {
		return dbURL;
	}

	protected Connection getConnection() {
		return connection;
	}

	protected Statement getSt() {
		return st;
	}

	public void kiemTraKetNoi() {
		if (this.connection != null) {
			System.out.println("Đã kết nối tới cơ sở dữ liệu");
		} else {
			System.out.println("Kết nối thất bại");
		}
	}

}
