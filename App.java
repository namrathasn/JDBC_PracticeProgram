package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("class found");
        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeData", "root", "PFH@23kgrw9");
        System.out.println("connected");
        String query = "select * from employee";
        Statement statement = root.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Employee> employees = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee employee = new Employee();
            employee.setEmpID(resultSet.getInt(1));
            employee.setEmpName(resultSet.getString(2));
            employee.setJobName(resultSet.getString(3));
            employee.setHireDate(resultSet.getDate(4));
            employee.setSalary(resultSet.getInt(5));
            employee.setDepID(resultSet.getInt(6));
            employees.add(employee);
        }
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println("...............");
            System.out.println(iterator.next());
            System.out.println("..............");
        }


    }
}
