package com.capgemini.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.employee.domain.Employee;


@WebServlet("/Employees")
public class EmployeeServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    private ArrayList<Employee>empData = new ArrayList<>();   
  
    public EmployeeServlet()
    {
        super();
    }
    @Override
    public void init(ServletConfig config) throws ServletException
    {
    	empData.add(new Employee("123","anu",18000,"java"));
    	empData.add(new Employee("456","devika",13000,"sap"));
    	empData.add(new Employee("789","keerthy",15000,"unix"));
    	empData.add(new Employee("234","srilu",10000,"cloud"));
    	empData.add(new Employee("123","teja",16000,"java"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String emploId = request.getParameter("empId");
		for (Employee employee : empData) 
		{
			if(employee.getEmployeeId().equals(emploId))
			{
				out.println("<table border='1'>");
				out.println("<tr><td>"+employee.getEmployeeId()+"</td><td>"+employee.getEmployeeName()+"</td><td>"+employee.getDepartmentName()+"</td><td>"+employee.getSalary());
				out.println("</tr></table>");

			}
		}
	}
}
