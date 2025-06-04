import java.text.DecimalFormat;
import java.util.Scanner;

class Employee {
    private double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public double getPercentage() {
        if (salary <= 400.00) return 0.15;
        else if (salary <= 800.00) return 0.12;
        else if (salary <= 1200.00) return 0.10;
        else if (salary <= 2000.00) return 0.07;
        else return 0.04;
    }

    public double getIncreaseAmount() {
        return salary * getPercentage();
    }

    public double getNewSalary() {
        return salary + getIncreaseAmount();
    }

    public void printSalaryInfo() {
        double percent = getPercentage() * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("New salary: " + df.format(getNewSalary()));
        System.out.println("Adjustment won: " + df.format(getIncreaseAmount()));
        System.out.println("In percentage: " + (int)percent + " %");
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputSalary = scanner.nextDouble();

        if (inputSalary < 0) {
            System.out.println("Invalid salary!");
        } else {
            Employee emp = new Employee(inputSalary);
            emp.printSalaryInfo();
        }
        scanner.close();
    }
}