package services;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import model.Department;

public class DepartmentService {
    private DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();

    public DepartmentService(){}

    public void saveDepartment(Department department){
        departmentDao.save(department);
    }
    public void updateDepartment(Department department){
        departmentDao.update(department);
    }
    public void deleteDepartment(Department department){
        departmentDao.delete(department);
    }
    public Department findByName(String name){
        return departmentDao.findByName(name);
    }
    public long getDepartmentEmployeesCount(String name){
        return departmentDao.getEmployeesCount(name);
    }
}
