package com.niit.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App 
{
	public static void addDepartment()
	{
	     Session session=DBConnection.getSession();
	     Transaction tx=session.beginTransaction();
	     
	     Department department=new Department();
	     department.setDepartmentname("HR");
	     
	     session.save(department);
	     tx.commit();
	}
	
	public static void displayEmployees()
	{
	     Session session=DBConnection.getSession();
	     List<Employee> employees=session.createQuery("from com.niit.hibernate.Employee").list();
	        
	     for(Employee employee:employees)
	     {
	    	 System.out.println("========Employee Details=============");
	    	 System.out.println("Employee Id: "+employee.getEmployeeid());
	    	 System.out.println("Employee Name: "+employee.getEmployeename());
	    	 System.out.println("Employee Email: "+employee.getEmail());
	    	 
	    	 System.out.println("========Department Details=============");
	    	 System.out.println("Department Id: "+employee.getDepartment().getDepartmentid());
	    	 System.out.println("Department Id: "+employee.getDepartment().getDepartmentname());
	    	 System.out.println();
	     }
	}
	
	public static void main( String[] args )
    {
		//addDepartment();
		displayEmployees();
    }
}
