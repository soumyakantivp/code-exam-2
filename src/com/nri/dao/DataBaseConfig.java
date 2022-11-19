package com.nri.dao;

import java.sql.*;

// Database Configuration Class
public class DataBaseConfig {
    private Connection con;
    
    public Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle"); // credentials
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("error occured in DB Connection");
        } 

        return con;
    }
}

