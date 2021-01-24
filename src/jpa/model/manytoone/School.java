package jpa.model.manytoone;

import javax.persistence.*;
import java.io.Serializable;

@Table
@Entity
public class School implements Serializable {
    private static final long serialVersionUID = 1L;

    private int schoolId;
    private String schoolName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SCHOOL_ID")
    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Column(name = "SCHOOL_NAME")
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
