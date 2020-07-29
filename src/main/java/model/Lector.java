package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "lector")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "second_name")
    private String second_name;

    @Column(name = "salary")
    private long salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "degree_id")
    private Degree degree;

    @OneToOne(mappedBy = "head")
    private Department department;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(name = "department_lectors", joinColumns = {@JoinColumn(name = "lector_id")},
                    inverseJoinColumns = {@JoinColumn(name = "department_id")})
    private Set<Department> departments = new HashSet<Department>();

    public  Lector(){
    }
    public  Lector(String name,String second_name, long salary,Degree degree){
        this.name = name;
        this.second_name = second_name;
        this.salary = salary;
        setDegree(degree);
    }

    public void addDepartment(Department department){
        departments.add(department);
        department.getLectors().add(this);
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

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }


}
