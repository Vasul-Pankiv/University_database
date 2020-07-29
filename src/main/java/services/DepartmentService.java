package services;

import dao.impl.DepartmentDaoImpl;
import model.Department;
import model.Lector;

public class DepartmentService {
    private DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

    public DepartmentService(){}

    public void save(Department department){
        departmentDao.save(department);
    }
    public void update(Department department){
        departmentDao.update(department);
    }
    public Department findByName(String name){
        return departmentDao.findByName(name);
    }
    public Lector getHeadByDepartmentName(String name){
        return departmentDao.getHeadByDepartmentName(name);
    }
    public long getDepartmentEmployeesCount(String name){
        return departmentDao.getEmployeesCountByDepartmentName(name);
    }
    public void delete(Department department){
        departmentDao.delete(department);
    }
}
