package com.organization.leavemanagement.Main;
import com.organization.leavemanagement.service.LeaveService;

import com.organization.leavemanagement.model.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        LeaveService service =
                new LeaveService();

        LeaveRequest request =
                new LeaveRequest(
                        "EMP101",
                        LeaveType.SICK,
                        3,
                        "Fever",
                        LocalDate.now()
                );

        try {

            service.applyLeave(request);

            System.out.println(
                    "Leave applied successfully");

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }
}