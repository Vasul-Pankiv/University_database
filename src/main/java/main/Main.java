package main;

import model.Degree;
import model.Department;
import model.Lector;
import services.DegreeService;
import services.DepartmentService;
import services.LectorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentService departmentService = new DepartmentService();
        LectorService lectorService = new LectorService();
        DegreeService degreeService = new DegreeService();

        String message, department_name,template;
        System.out.println("Menu:\n" +
                "1. Who is head of department {department_name}\n" +
                "2. Show {department_name} statistic\n" +
                "3. Show the average salary for department {department name}\n" +
                "4. Show count of employee for department {department_name}\n" +
                "5. Global search by {template}\n" +
                "Your choice: ");
        Scanner sc = new Scanner(System.in);
        String command = sc.next();

        switch (command){
            case "1":
                System.out.println("Input department name: ");
                department_name = sc.next();
                String head_name = departmentService.getHeadByDepartmentName(department_name).getName();
                message = "Haed of "+department_name+" department is: "+head_name;
                System.out.println(message);
                break;
            case "2":
                System.out.println("Input department name: ");
                department_name = sc.next();
                message = departmentService.getDepartmentStatisticByDepartmentName(department_name);
                System.out.println(message);

                break;
            case "3":
                System.out.println("Input department name: ");
                department_name = sc.next();
                message = "Average salary of "+department_name+"department: "+departmentService.getAverageSalaryByDepartmentName(department_name);
                System.out.println(message);
                break;
            case "4":
                System.out.println("Input department name: ");
                department_name = sc.next();
                message = department_name+" employees count: "+departmentService.getDepartmentEmployeesCount(department_name);
                System.out.println(message);
                break;
            case "5":
                System.out.println("Input template: ");
                template = sc.next();
                Set<Lector> lectors = lectorService.globalSearch(template);
                for (Lector l : lectors) {
                    System.out.println("Name: "+l.getName()+" second name: "+l.getSecond_name());
                }
                break;
        }
    }
}