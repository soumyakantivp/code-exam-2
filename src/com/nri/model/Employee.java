package com.nri.model;

// Employee Class or Entity with different attributes
public class Employee {
    private int empid;
    private String empname;
    private double empsalary;



    // Getter and Setter Methods
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(double empsalary) {
        this.empsalary = empsalary;
    }

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empsalary=" + empsalary + "]";
	}

    
}
