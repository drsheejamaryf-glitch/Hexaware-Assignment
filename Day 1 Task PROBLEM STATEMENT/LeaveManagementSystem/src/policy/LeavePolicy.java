package policy;

import model.Employee;
import model.LeaveRequest;

public interface LeavePolicy {

    void validateLeave(Employee employee,
                       LeaveRequest request)
            throws Exception;
}