package policy;

import model.Employee;
import model.LeaveRequest;

public class EarnedLeavePolicy implements LeavePolicy {

    @Override
    public void validateLeave(Employee employee,
                              LeaveRequest request)
            throws Exception {

        if (request.getNumberOfDays()
                > employee.calculateMaxAllowedLeave()) {

            throw new Exception(
                    "Exceeded maximum allowed leave");
        }
    }
}