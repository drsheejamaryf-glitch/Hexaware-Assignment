package policy;

import model.Employee;
import model.LeaveRequest;

public class SickLeavePolicy implements LeavePolicy {

    @Override
    public void validateLeave(Employee employee,
                              LeaveRequest request)
            throws Exception {

        if (request.getNumberOfDays() > 10) {

            throw new Exception(
                    "Sick Leave exceeds limit");
        }
    }
}