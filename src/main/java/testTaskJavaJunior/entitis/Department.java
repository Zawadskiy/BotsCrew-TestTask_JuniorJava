package testTaskJavaJunior.entitis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ToString.Exclude
    @ManyToMany(mappedBy = "departments")
    List<Lector> lectors;

    @Column(nullable = false)
    String department_name;

    @Column
    String head_of_department;


    public Department(String department_name, String head_of_department) {
        this.department_name = department_name;
        this.head_of_department = head_of_department;
    }

    public Long getId() {
        return id;
    }

    public String getHead_of_department() {
        return head_of_department;
    }
}
