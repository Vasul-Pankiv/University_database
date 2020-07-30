package dao.impl;

import dao.LectorDao;
import model.Department;
import model.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LectorDaoImpl implements LectorDao {

    public Lector findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Lector lector= session.get(Lector.class, id);
        tx.commit();
        session.close();
        return lector;
    }

    public void save(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(lector);
        tx.commit();
        session.close();
    }

    public void delete(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(lector);
        tx.commit();
        session.close();
    }

    public void update(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(lector);
        tx.commit();
        session.close();
    }

    public List<Lector> findAll() {
        List<Lector> lectors= (List<Lector>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Lector").list();
        return lectors;
    }
    public  Set<Lector> globalSearch(String template){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Lector WHERE name like ?1");
        query.setParameter(1,"%"+template+"%");
        List<Lector> lectors = (List<Lector>) query.list();
        query = session.createQuery("FROM Lector WHERE second_name LIKE ?1 ");
        query.setParameter(1,"%"+template+"%");
        List<Lector> lectors2 = (List<Lector>) query.list();
        Set<Lector> result = new HashSet<>(lectors);
        result.addAll(lectors2);
        session.close();
        return result;
    }
}
