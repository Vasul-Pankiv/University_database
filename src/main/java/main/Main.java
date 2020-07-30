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
        Scanner sc = new Scanner(System.in);
        String command = "";

        while (!command.equals("0")){

            System.out.println("Menu:\n" +
                    "1. Who is head of department {department_name}\n" +
                    "2. Show {department_name} statistic\n" +
                    "3. Show the average salary for department {department name}\n" +
                    "4. Show count of employee for department {department_name}\n" +
                    "5. Global search by {template}\n" +
                    "0. exit\n"+
                    "Your choice: ");
            command = sc.next();

            switch (command){
                case "1":
                    System.out.println("Input department name: ");
                    department_name = sc.next();
                    if(departmentService.findByName(department_name)!=null){
                        if(departmentService.getHeadByDepartmentName(department_name)==null){
                            System.out.println("Head does not exist!");
                        }
                        else{
                            String head_name = departmentService.getHeadByDepartmentName(department_name).getName();
                            message = "Haed of "+department_name+" department is: "+head_name;
                            System.out.println(message);
                        }
                    }
                    else {
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "2":
                    System.out.println("Input department name: ");
                    department_name = sc.next();
                    if(departmentService.findByName(department_name)!=null){
                        message = departmentService.getDepartmentStatisticByDepartmentName(department_name);
                        System.out.println(message);
                    }
                    else{
                        System.out.println("Department does not exist!");
                    }

                    break;
                case "3":
                    System.out.println("Input department name: ");
                    department_name = sc.next();
                    if(departmentService.findByName(department_name)!=null){
                        message = "Average salary of "+department_name+"department: "+departmentService.getAverageSalaryByDepartmentName(department_name);
                        System.out.println(message);
                    }
                    else{
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "4":
                    System.out.println("Input department name: ");
                    department_name = sc.next();
                    if(departmentService.findByName(department_name)!=null){
                        message = department_name+" employees count: "+departmentService.getDepartmentEmployeesCount(department_name);
                        System.out.println(message);
                    }
                    else{
                        System.out.println("Department does not exist!");
                    }
                    break;
                case "5":
                    System.out.println("Input template: ");
                    template = sc.next();
                    Set<Lector> lectors = lectorService.globalSearch(template);
                    if(lectors.isEmpty()){
                        System.out.println("Matches not found...");
                    }
                    else{
                        for (Lector l : lectors) {
                            System.out.println("Name: "+l.getName()+" second name: "+l.getSecond_name());
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