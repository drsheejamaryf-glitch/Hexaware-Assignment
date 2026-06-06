package main;

import model.Employee;
import model.LeaveRequest;
import model.PermanentEmployee;
import policy.CasualLeavePolicy;
import policy.LeavePolicy;
import repository.LeaveRepository;
import service.LeaveService;

public class Main {

    public static void main(String[] args) {

        Employee employee =
                new PermanentEmployee(
                        "E101",
                        "John",
                        15);

        LeaveRequest request =
                new LeaveRequest(
                        "Casual",
                        3,
                        employee);

        LeavePolicy policy =
                new CasualLeavePolicy();

        LeaveRepository repository =
                new LeaveRepository();

        LeaveService service =
                new LeaveService(
                        policy,
                        repository);

        service.applyLeave(
                employee,
                request);

        System.out.println(
                "Leave Status: "
                        + request.getStatus());

        System.out.println(
                "Remaining Balance: "
                        + employee.getLeaveBalance());
    }
}