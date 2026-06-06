package service;

import model.Employee;
import model.LeaveRequest;
import model.LeaveStatus;
import policy.LeavePolicy;
import repository.LeaveRepository;

public class LeaveService {

    private LeavePolicy leavePolicy;
    private LeaveRepository repository;

    public LeaveService(LeavePolicy leavePolicy,
                        LeaveRepository repository) {

        this.leavePolicy = leavePolicy;
        this.repository = repository;
    }

    public void applyLeave(Employee employee,
                           LeaveRequest request) {

        try {

            leavePolicy.validateLeave(employee, request);

            if (employee.getLeaveBalance()
                    < request.getNumberOfDays()) {

                throw new Exception(
                        "Insufficient leave balance");
            }

            employee.setLeaveBalance(
                    employee.getLeaveBalance()
                            - request.getNumberOfDays());

            request.setStatus(
                    LeaveStatus.APPROVED);

        } catch (Exception e) {

            request.setStatus(
                    LeaveStatus.REJECTED);

            System.out.println(e.getMessage());
        }

        repository.addLeaveRequest(request);
    }
}