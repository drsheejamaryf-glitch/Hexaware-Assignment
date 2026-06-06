package com.organization.leavemanagement.service;

import com.organization.leavemanagement.exception.*;
import com.organization.leavemanagement.model.Employee;
import com.organization.leavemanagement.model.LeaveRequest;
import com.organization.leavemanagement.repository.EmployeeRepository;
import com.organization.leavemanagement.repository.LeaveRepository;
import com.organization.leavemanagement.util.ValidationUtil;

public class LeaveService {

    private EmployeeRepository employeeRepository =
            new EmployeeRepository();

    private LeaveRepository leaveRepository =
            new LeaveRepository();

    public void applyLeave(LeaveRequest request)
            throws Exception {

        ValidationUtil.validateString(
                request.getReason(),
                "Reason");

        ValidationUtil.validateDays(
                request.getNumberOfDays());

        Employee employee =
                employeeRepository.findEmployeeById(
                        request.getEmployeeId());

        if (employee == null) {

            throw new EmployeeNotFoundException(
                    "Employee not found");
        }

        if (request.getNumberOfDays() >
                employee.getLeaveBalance()) {

            throw new InsufficientLeaveBalanceException(
                    "Insufficient leave balance");
        }

        if (employee.getTotalLeaveTaken() +
                request.getNumberOfDays() > 20) {

            throw new InvalidLeaveRequestException(
                    "Yearly leave limit exceeded");
        }

        if (request.getLeaveType().name()
                .equals("SICK")
                && request.getNumberOfDays() > 5) {

            throw new InvalidLeaveRequestException(
                    "Maximum 5 sick leaves allowed");
        }

        employee.setLeaveBalance(
                employee.getLeaveBalance()
                        - request.getNumberOfDays());

        employee.setTotalLeaveTaken(
                employee.getTotalLeaveTaken()
                        + request.getNumberOfDays());

        employeeRepository.updateEmployee(employee);

        leaveRepository.saveLeaveRequest(request);
    }
}