package model;

public class LeaveRequest {

    private String leaveType;
    private int numberOfDays;
    private LeaveStatus status;
    private Employee employee;

    public LeaveRequest(String leaveType,
                        int numberOfDays,
                        Employee employee) {

        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.employee = employee;
        this.status = LeaveStatus.PENDING;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void setStatus(LeaveStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }
}