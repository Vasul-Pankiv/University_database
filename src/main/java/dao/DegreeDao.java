package dao;

import model.Degree;
import model.Lector;

import java.util.List;
import java.util.Set;

public interface DegreeDao {
    Degree findById(long id);
    void save(Degree degree);
    void delete(Degree degree);
    void update(Degree degree);
    Set<Degree> findAll();
}
