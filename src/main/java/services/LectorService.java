package services;

import dao.impl.DepartmentDaoImpl;
import dao.impl.LectorDaoImpl;
import model.Department;
import model.Lector;

import java.util.Set;

public class LectorService {
    private LectorDaoImpl lectorDao = new LectorDaoImpl();

    public LectorService(){}

    public void saveLector(Lector lector){
        lectorDao.save(lector);
    }
    public void updateLector(Lector lector){
        lectorDao.update(lector);
    }
    public void deleteLector(Lector lector){
        lectorDao.delete(lector);
    }
    public Set<Lector> globalSearch(String template){
        return lectorDao.globalSearch(template);
    }
}
