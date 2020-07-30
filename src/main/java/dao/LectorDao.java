package dao;

import model.Lector;
import java.util.*;

public interface LectorDao {
    Lector findById(long id);
    void save(Lector lector);
    void delete(Lector lector);
    void update(Lector lector);
    List<Lector> findAll();
    Set<Lector> globalSearch(String template);

}
