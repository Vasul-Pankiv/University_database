package dao.impl;


import dao.DepartmentDao;
import model.Department;
import model.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {
    public Department findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Department department= session.get(Department.class, id);
        tx1.commit();
        session.close();
        return department;
    }

    public Department findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Query query= session.createQuery("from Department where name=:name");
        query.setParameter("name", name);
        Department department = (Department) query.uniqueResult();
        tx1.commit();
        session.close();
        return department;
    }

    public void save(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(department);
        tx1.commit();
        session.close();
    }

    public void delete(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(department);
        tx1.commit();
        session.close();
    }

    public void update(Department department) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(department);
        tx1.commit();
        session.close();
    }

    public Set<Department> findAll() {
        Set<Department> departments = (Set<Department>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Department").list();
        return departments;
    }

    public void showStatistic(String name) {

    }

    public Lector getHeadByDepartmentName(String name) {
        Lector lector = findByName(name).getHead();
        return lector;
    }

    public long getAverageSalaryByDepartmentName(String name) {
        return 0;
    }

    public long getEmployeesCountByDepartmentName(String name) {
        Department department = findByName(name);
        int employeesCount = department.getLectors().size();
        return employeesCount;
    }
}