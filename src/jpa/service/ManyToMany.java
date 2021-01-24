package jpa.service;

import jpa.model.manytomany.Kelas;
import jpa.model.manytomany.Teacher;
import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ManyToMany {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        // bikin 3  kelas, 3 teacher

//        Kelas kelas1 = new Kelas("8E");
//        Kelas kelas2 = new Kelas("8D");

//        entityManager.persist(kelas1);
//        entityManager.persist(kelas2);

//        Set<Kelas> kelasList1 = new HashSet<>();
//        kelasList1.add(kelas1);
//        kelasList1.add(kelas2);

//        Set<Kelas> kelasList2 = new HashSet<>();
//        kelasList2.add(kelas1);

//        Teacher teacher1 = new Teacher("Evan", "Math", kelasList1);
//        Teacher teacher2 = new Teacher("Budi", "Science", kelasList2);
//
//        entityManager.persist(teacher1);
//        entityManager.persist(teacher2);

        Kelas kelas = entityManager.find(Kelas.class, 751L);
        Kelas kelas2 = entityManager.find(Kelas.class, 752L);

        Set<Kelas> kelasSet = new HashSet<>();
        kelasSet.add(kelas);
//        kelasSet.add(kelas2);
        updateTeacherClass(entityManager, 754L, kelasSet);

        entityManager.getTransaction().commit();

        entityManager.close();
        emfactory.close();
    }

    public static void updateTeacherClass(EntityManager entityManager, Long teacherId, Set<Kelas> kelasSet) {
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        teacher.setKelasStudents(kelasSet);
//        entityManager.persist(teacher);
    }
}
