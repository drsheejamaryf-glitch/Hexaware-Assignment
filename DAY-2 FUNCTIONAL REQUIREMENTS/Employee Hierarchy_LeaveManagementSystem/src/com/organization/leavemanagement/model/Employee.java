package com.organization.leavemanagement.model;

public class Employee {

    private String employeeId;
    private String name;
    private int leaveBalance;
    private int totalLeaveTaken;

    public Employee(String employeeId,
                    String name,
                    int leaveBalance,
                    int totalLeaveTaken) {

        this.employeeId = employeeId;
        this.name = name;
        this.leaveBalance = leaveBalance;
        this.totalLeaveTaken = totalLeaveTaken;
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

    public int getTotalLeaveTaken() {
        return totalLeaveTaken;
    }

    public void setTotalLeaveTaken(int totalLeaveTaken) {
        this.totalLeaveTaken = totalLeaveTaken;
    }
}
