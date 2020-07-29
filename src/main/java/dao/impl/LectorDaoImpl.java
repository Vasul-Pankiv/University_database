package dao.impl;

import dao.LectorDao;
import model.Department;
import model.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;
import java.util.Set;

public class LectorDaoImpl implements LectorDao {

    public Lector findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Lector lector= session.get(Lector.class, id);
        tx1.commit();
        session.close();
        return lector;
    }

    public void save(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(lector);
        tx1.commit();
        session.close();
    }

    public void delete(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(lector);
        tx1.commit();
        session.close();
    }

    public void update(Lector lector) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(lector);
        tx1.commit();
        session.close();
    }

    public List<Lector> findAll() {
        List<Lector> lectors= (List<Lector>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Lector").list();
        return lectors;
    }
}
