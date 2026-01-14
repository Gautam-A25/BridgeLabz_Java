package object_oriented_programming.ObjectModelling;

import java.util.ArrayList;

class EmployeeComp {
    private String name;
    private String role;

    public EmployeeComp(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployee() {
        System.out.println("   Employee: " + name + " | Role: " + role);
    }
}

class DepartmentComp {
    private String deptName;
    private ArrayList<EmployeeComp> employees;

    public DepartmentComp(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public String getDeptName() {
        return deptName;
    }

    public void addEmployee(String name, String role) {
        employees.add(new EmployeeComp(name, role));
    }

    public void displayDept() {
        System.out.println(" Department: " + deptName);
        for (EmployeeComp e : employees) {
            e.displayEmployee();
        }
        System.out.println();
    }
}

class CompanyComp {
    private String companyName;
    private ArrayList<DepartmentComp> departments;

    public CompanyComp(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new DepartmentComp(deptName));
    }

    public DepartmentComp getDepartment(String deptName) {
        for (DepartmentComp d : departments) {
            if (d.getDeptName().equals(deptName)) {
                return d;
            }
        }
        return null;
    }

    public void displayCompany() {
        System.out.println("Company: " + companyName);
        for (DepartmentComp d : departments) {
            d.displayDept();
        }
    }

    public void deleteCompany() {
        System.out.println("Deleting company: " + companyName);
        departments.clear();
    }
}

public class CompanyDeptComp {
    public static void main(String[] args) {
        CompanyComp company = new CompanyComp("Capgemini");

        company.addDepartment("IT");
        company.addDepartment("Human Resource");

        DepartmentComp itDept = company.getDepartment("IT");
        if (itDept != null) {
            itDept.addEmployee("Dinesh", "Software Engineer");
            itDept.addEmployee("Jason", "System Admin");
        }

        DepartmentComp hrDept = company.getDepartment("Human Resource");
        if (hrDept != null) {
            hrDept.addEmployee("Karthik", "HR Manager");
        }

        company.displayCompany();
        company.deleteCompany();
        company.displayCompany();
    }
}