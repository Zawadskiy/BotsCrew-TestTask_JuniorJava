package testTaskJavaJunior.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import testTaskJavaJunior.MyDegree;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Lector {

    public Lector(String name,MyDegree degree, Integer salary) {
        this.degree = degree;
        this.name = name;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    MyDegree degree;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="department_lectors",
            joinColumns= {@JoinColumn(name = "lector", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "department", referencedColumnName = "id")}
    )
    List<Department> departments;

    @Column
    Integer salary;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "head_of_department")
//    List<Department> head_in_deps;


    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

//    public void setHead_in_deps(List<Department> head_in_deps) {
//        this.head_in_deps = head_in_deps;
//    }

    public Long getId() {
        return id;
    }

    public MyDegree getDegree() {
        return degree;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Integer getSalary() {
        return salary;
    }

//    public List<Department> getHead_in_deps() {
//        return head_in_deps;
//    }
}
