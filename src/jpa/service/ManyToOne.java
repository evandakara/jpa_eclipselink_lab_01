package jpa.service;

import jpa.model.manytoone.School;
import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOne {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        School school = new School();
        school.setSchoolName("Labschool");

        entityManager.persist(school);

        Student student1 = new Student();
        student1.setName("Evan");
        student1.setAddress("Tebet");
        student1.setAge(34);
        student1.setSchool(school);

        Student student2 = new Student();
        student2.setName("navE");
        student2.setAddress("tebeT");
        student2.setAge(43);
        student2.setSchool(school);

        entityManager.persist(student1);
        entityManager.persist(student2);

        entityManager.getTransaction().commit();
        entityManager.close();
        emfactory.close();
    }
}
