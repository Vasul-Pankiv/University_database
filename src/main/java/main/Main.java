package main;

import model.Lector;
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
        String message, departmentName, template;
        Scanner sc = new Scanner(System.in);
        String command = "";

        while (!command.equals("0")) {
            //new commit
            System.out.println("Menu:\n" +
                    "1. Who is head of department {department_name}\n" +
                    "2. Show {department_name} statistic\n" +
                    "3. Show the average salary for department {department name}\n" +
                    "4. Show count of employee for department {department_name}\n" +
                    "5. Global search by {template}\n" +
                    "0. exit\n" +
                    "Your choice: ");
            command = sc.next();

            switch (command) {
                case "1":
                    System.out.println("Input department name: ");
                    departmentName = sc.next();
                    if (departmentService.findByName(departmentName) != null) {
                        if (departmentService.getHeadByDepartmentName(departmentName) == null) {
                            System.out.println("Head does not exist!");
                        } else {
                            String head_name = departmentService.getHeadByDepartmentName(departmentName).getName();
                            message = "Haed of " + departmentName + " department is: " + head_name;
                            System.out.println(message);
                        }
                    } else {
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "2":
                    System.out.println("Input department name: ");
                    departmentName = sc.next();
                    if (departmentService.findByName(departmentName) != null) {
                        message = departmentService.getDepartmentStatisticByDepartmentName(departmentName);
                        System.out.println(message);
                    } else {
                        System.out.println("Department does not exist!");
                    }

                    break;
                case "3":
                    System.out.println("Input department name: ");
                    departmentName = sc.next();
                    if (departmentService.findByName(departmentName) != null) {
                        message = "Average salary of " + departmentName + "department: " + departmentService.getAverageSalaryByDepartmentName(departmentName);
                        System.out.println(message);
                    } else {
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "4":
                    System.out.println("Input department name: ");
                    departmentName = sc.next();
                    if (departmentService.findByName(departmentName) != null) {
                        message = departmentName + " employees count: " + departmentService.getDepartmentEmployeesCount(departmentName);
                        System.out.println(message);
                    } else {
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "5":
                    System.out.println("Input template: ");
                    template = sc.next();
                    Set<Lector> lectors = lectorService.globalSearch(template);
                    if (lectors.isEmpty()) {
                        System.out.println("Matches not found...");
                    } else {
                        for (Lector l : lectors) {
                            System.out.println("Name: " + l.getName() + " second name: " + l.getSecond_name());
                        }
                    }
                    break;
                case "0":
                    System.out.println("Process finished");
                    break;
                default:
                    System.out.println("Please, input correct command");
                    break;
            }
        }

    }
}