package com.organization.leavemanagement.repository;

import com.organization.leavemanagement.model.LeaveRequest;
import com.organization.leavemanagement.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaveRepository {

    public void saveLeaveRequest(LeaveRequest request)
            throws SQLException {

        Connection con = DBUtil.getConnection();

        String sql =
                "INSERT INTO leave_request(employee_id, leave_type, number_of_days, reason, request_date) VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, request.getEmployeeId());
        ps.setString(2, request.getLeaveType().name());
        ps.setInt(3, request.getNumberOfDays());
        ps.setString(4, request.getReason());
        ps.setDate(5,
                java.sql.Date.valueOf(
                        request.getRequestDate()));

        ps.executeUpdate();
    }
}