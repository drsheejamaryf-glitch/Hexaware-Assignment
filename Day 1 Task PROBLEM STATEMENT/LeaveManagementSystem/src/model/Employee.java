package model;

public abstract class Employee {

    private String employeeId;
    private String name;
    protected int leaveBalance;

    public Employee(String employeeId,
                    String name,
                    int leaveBalance) {

        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }

    public abstract int calculateMaxAllowedLeave();
}