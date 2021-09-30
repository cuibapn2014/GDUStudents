package com.vn.gdustudent.v1;

import java.sql.*;

public class KetNoiCSDL{
	public KetNoiCSDL() throws SQLException {
	final String dbURL = "jdbc:sqlserver://localhost;databaseName=managestu;user=sa;password=tuannguyen123;";
    final Connection conn = DriverManager.getConnection(dbURL);
	}
}
