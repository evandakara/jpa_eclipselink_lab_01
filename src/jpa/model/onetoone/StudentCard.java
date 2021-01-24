package jpa.model.onetoone;

import jpa.model.manytoone.Student;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class StudentCard implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Student student;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
