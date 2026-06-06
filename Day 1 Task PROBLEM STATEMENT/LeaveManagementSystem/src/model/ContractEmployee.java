package model;

public class ContractEmployee extends Employee {

    public ContractEmployee(String employeeId,
                            String name,
                            int leaveBalance) {

        super(employeeId, name, leaveBalance);
    }

    @Override
    public int calculateMaxAllowedLeave() {

        return 10;
    }
}