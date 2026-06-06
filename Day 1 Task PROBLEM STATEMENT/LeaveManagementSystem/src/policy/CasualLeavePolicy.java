package policy;

import model.Employee;
import model.LeaveRequest;

public class CasualLeavePolicy implements LeavePolicy {

    @Override
    public void validateLeave(Employee employee,
                              LeaveRequest request)
            throws Exception {

        if (request.getNumberOfDays() > 5) {

            throw new Exception(
                    "Casual Leave cannot exceed 5 days");
        }
    }
}