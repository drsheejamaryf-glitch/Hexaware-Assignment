package com.organization.leavemanagement.repository;

import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.util.DBUtil;

import java.sql.*;

public class EmployeeRepository {

    public Employee findEmployeeById(String employeeId)
            throws SQLException {

        Connection con = DBUtil.getConnection();

        String sql =
                "SELECT * FROM employee WHERE employee_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, employeeId);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new Employee(
                    rs.getString("employee_id"),
                    rs.getString("name"),
                    rs.getInt("leave_balance"),
                    rs.getInt("total_leave_taken")
            );
        }

        return null;
    }

    public void updateEmployee(Employee employee)
            throws SQLException {

        Connection con = DBUtil.getConnection();

        String sql =
                "UPDATE employee SET leave_balance=?, total_leave_taken=? WHERE employee_id=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employee.getLeaveBalance());
        ps.setInt(2, employee.getTotalLeaveTaken());
        ps.setString(3, employee.getEmployeeId());

        ps.executeUpdate();
    }
}