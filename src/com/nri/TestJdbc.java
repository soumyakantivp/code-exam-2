package com.nri;

import com.nri.dao.EmployeeDao;
import com.nri.model.Employee;

/*
 * Write a program to insert, update, search and delete (CRUD) a record representing an
 * employee object with only empid, empname and empsalary attributes using JDBC and Oracle
 * Database
*/
public class TestJdbc {
	private static EmployeeDao empdao;

	// insert demo
	public static void initData() {
		// Employee Dummy Data
		Employee empobj = new Employee();
		empobj.setEmpid(1);
		empobj.setEmpname("Soumya Kanti");
		empobj.setEmpsalary(15000);

		Employee empobj2 = new Employee();
		empobj2.setEmpid(2);
		empobj2.setEmpname("Sandeep Sir");
		empobj2.setEmpsalary(70000);

		Employee empobj3 = new Employee();
		empobj3.setEmpid(3);
		empobj3.setEmpname("James Gosling");
		empobj3.setEmpsalary(9999999);

		// insert Employees into tblemployee
		empdao.rcrInsert(empobj);
		empdao.rcrInsert(empobj2);
		empdao.rcrInsert(empobj3);

		System.out.println("# Employee Data Initialized: ");
		empdao.getAllEmployee();
	}

	// update demo
	public static void updateData() {
		Employee empobj2Updated = new Employee();
		empobj2Updated.setEmpid(2);
		empobj2Updated.setEmpname("Sandeep Sandilya");
		empobj2Updated.setEmpsalary(70000);
		empdao.rcrUpdate(empobj2Updated);

		System.out.println("# Updating Sandeep Sir to Sandeep Sandilya: ");
		empdao.getAllEmployee();
	}

	// delete demo
	public static void deleteData() {
		empdao.rcrDelete(3);
		System.out.println("# Deleting Employee with empid 3: ");
		empdao.getAllEmployee();
	}
	
	// search by ID demo
	public static void getEmployeeData() {
		System.out.println("# Fetching Employee with empid 1: ");
		empdao.getEmployee(1);
	}
	
	// fetch all records
	public static void getAllEmployeeData() {
		System.out.println("# Fetching all Employees");
		empdao.getAllEmployee();
	}

	// main method
	public static void main(String[] args) {
		// Initialized empdao
		empdao = new EmployeeDao();

		initData(); // inserts dummy data into table
		updateData(); // updates specific record in table
		deleteData(); // deletes specific record in table
		getEmployeeData(); // fetches employee by ID
		getAllEmployeeData(); // fetches all employees 
	}
}
