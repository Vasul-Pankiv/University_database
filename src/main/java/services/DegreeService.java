package services;

import dao.DegreeDao;
import dao.impl.DegreeDaoImpl;
import model.Degree;

public class DegreeService {
    public DegreeService(){}
    DegreeDaoImpl degreeDao = new DegreeDaoImpl();

    public Degree findeById(long id){
        return degreeDao.findById(id);
    }
    public void save(Degree degree){
        degreeDao.save(degree);
    }
    public void delete(Degree degree){
        degreeDao.delete(degree);
    }
    public void update(Degree degree){
        degreeDao.update(degree);
    }
}
