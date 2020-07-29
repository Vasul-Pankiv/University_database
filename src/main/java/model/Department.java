package model;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "head_id", referencedColumnName = "id")
    private Lector head;

    @ManyToMany(mappedBy = "departments",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Lector> lectors = new HashSet<Lector>();

    public  Department(){}

    public  Department(String name){

        this.name=name;
    }
    public void addLector(Lector lector){
        lectors.add(lector);
        lector.getDepartments().add(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    public Lector getHead() {
        return head;
    }

    public void setHead(Lector lector) {
        this.head = head;
    }
}
