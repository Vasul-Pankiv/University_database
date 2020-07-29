package main;

import model.Degree;
import model.Department;
import model.Lector;
import services.DegreeService;
import services.DepartmentService;
import services.LectorService;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        DepartmentService departmentService = new DepartmentService();
        LectorService lectorService = new LectorService();
        DegreeService degreeService = new DegreeService();

        Degree assistant = new Degree("assistant");
        Degree associate_proffesor = new Degree("associate-proffesor");
        Degree proffesor = new Degree("proffesor");

        Department department = new Department("SAPR");
        Department department1 = new Department("KI");
        Department department2 = new Department("ASU");
        Lector lector = new Lector("Vasul","Pankiv",10000,assistant);
        Lector lector1 = new Lector("Vasul","Pankiv",10000,assistant);
        Lector lector2 = new Lector("Vasul","Pankiv",10000,assistant);

        departmentService.saveDepartment(department);
        departmentService.saveDepartment(department1);
        departmentService.saveDepartment(department2);
        degreeService.save(assistant);
        degreeService.save(associate_proffesor);
        degreeService.save(proffesor);
        lectorService.saveLector(lector);
        lectorService.saveLector(lector1);
        lectorService.saveLector(lector2);

        lector.addDepartment(department);
        lector.addDepartment(department1);
        lector.addDepartment(department2);
        lectorService.updateLector(lector);
        department.addLector(lector1);
        department.addLector(lector2);
        departmentService.updateDepartment(department);

        System.out.println(departmentService.getDepartmentEmployeesCount("SAPR"));

        String department_name;
        String template;
        System.out.println("Menu:\n" +
                "1. Who is head of department {department_name}\n" +
                "2. Show {department_name} statistic\n" +
                "3. Show the average salary for department {department name}\n" +
                "4. Show count of employee for department {department_name}\n" +
                "5. Global search by {template}\n" +
                "Your choice: ");
        int choice = (int) System.in.read();

        switch (choice){
            case 1:
                System.out.println("Input department name: ");
                department_name = String.valueOf(System.in.read());

                break;
            case 2:
                System.out.println("Input department name: ");
                department_name = String.valueOf(System.in.read());
                break;
            case 3:
                System.out.println("Input department name: ");
                department_name = String.valueOf(System.in.read());
                break;
            case 4:
                System.out.println("Input department name: ");
                department_name = String.valueOf(System.in.read());
                break;
            case 5:
                System.out.println("Input template: ");
                template = String.valueOf(System.in.read());
                break;
        }
    }
}