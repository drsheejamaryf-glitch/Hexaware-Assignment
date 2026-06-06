package repository;

import model.LeaveRequest;

import java.util.ArrayList;
import java.util.List;

public class LeaveRepository {

    private List<LeaveRequest> leaveRequests =
            new ArrayList<>();

    public void addLeaveRequest(
            LeaveRequest request) {

        leaveRequests.add(request);
    }

    public List<LeaveRequest> getAllRequests() {

        return leaveRequests;
    }
}