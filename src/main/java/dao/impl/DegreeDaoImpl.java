package dao.impl;

import dao.DegreeDao;
import model.Degree;
import model.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.Set;

public class DegreeDaoImpl implements DegreeDao {
    @Override
    public Degree findById(long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Degree degree= session.get(Degree.class, id);
        tx1.commit();
        session.close();
        return degree;
    }

    @Override
    public void save(Degree degree) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(degree);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Degree degree) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(degree);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Degree degree) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(degree);
        tx1.commit();
        session.close();
    }

    @Override
    public Set<Degree> findAll() {
        return null;
    }
}
