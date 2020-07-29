package dao;

import model.Department;
import model.Lector;

import java.util.Set;


public interface DepartmentDao {
     Department findById(long id);
     Department findByName(String name);
     void save(Department department);
     void delete(Department department);
     void update(Department department);
     Set<Department> findAll();
     void showStatistic(String name);
     Lector showHead(String name);
     long showAverageSalary(String name);
     long getEmployeesCount(String name);

}
