package model;

public class PermanentEmployee extends Employee {

    public PermanentEmployee(String employeeId,
                             String name,
                             int leaveBalance) {

        super(employeeId, name, leaveBalance);
    }

    @Override
    public int calculateMaxAllowedLeave() {

        return 20;
    }
}