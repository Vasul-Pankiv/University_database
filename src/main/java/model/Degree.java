package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "degrees")
public class Degree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "degreeName")
    String degree;

    @OneToMany(mappedBy = "degree",cascade = CascadeType.ALL)
    private Set<Lector> lectors;

    public Degree(){}

    public Degree(String degree){
        this.degree=degree;
    }


    public void addLector(Lector lector){
        lector.setDegree(this);
        lectors.add(lector);
    }

    public String getDegree() {
        return degree;
    }

    public void removeLector(Lector lector){
        lectors.remove(lector);
    }

    public long getId() {
        return id;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }


}
