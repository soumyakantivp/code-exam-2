package com.nri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.nri.model.Employee;

// Class for all Database operations
public class EmployeeDao {

	private Connection con;
	private Statement statement;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// Constructor 
	public EmployeeDao() {
		DataBaseConfig config = new DataBaseConfig();
		this.con = config.getConnection();
		String query = "create table tblemployee(empid NUMBER(3) primary key, empname VARCHAR(50), empsalary NUMBER(10,2))";

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
			System.out.println("Created table in given database...");
		} catch (SQLException e) {
			System.out.println("table tblemployee already exists!!");
		}
		
	}

	// Insert new Employee
	public void rcrInsert(Employee employee) {
		String query = "insert into tblemployee values(?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, employee.getEmpid());
			pstmt.setString(2, employee.getEmpname());
			pstmt.setDouble(3, employee.getEmpsalary());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error occured");
		}

	}

	// Update Employee
	public void rcrUpdate(Employee employee) {

		String query = "update tblemployee set empname=?,empsalary=? where empid=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, employee.getEmpname());
			pstmt.setDouble(2, employee.getEmpsalary());
			pstmt.setInt(3, employee.getEmpid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error occured");
		}

	}

	// Delete Employee by ID
	public void rcrDelete(int empid) {
		String query = "delete from tblemployee where empid=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error occured");
		}

	}

	// Fetch Employee by ID
	public void getEmployee(int empid) {
		String query = "select * from tblemployee where empid=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empid);
			rs = pstmt.executeQuery(); // return ResultSet
			
			if (rs.next()) {
				System.out.println(" ["+rs.getInt("empid") + " " + rs.getString("empname") + " " + rs.getString("empsalary")+"]");
			} else {
				System.out.println("Record not found");
			}
		} catch (SQLException e) {
			System.out.println("error occured");
		}

	}

	// Fetch all Employee 
	public void getAllEmployee() {
		String msgsql = "Select * from tblemployee";
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(msgsql);

			while (rs.next()) {
				System.out.println(" ["+rs.getInt("empid") + " " + rs.getString("empname") + " " + rs.getString("empsalary")+"]");
			}
		} catch (SQLException e) {
			System.out.println("error occured");
		}

	}

}
