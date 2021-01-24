package jpa.service;

import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UpdateStudent {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, "SD02");
        System.out.println("Before update: " + student.getId() + " " + student.getName());

        student.setName("Dakara");
        entityManager.getTransaction().commit();
        System.out.println("After update: " + student.getId() + " " + student.getName());

        entityManager.close();
        emfactory.close();
    }
}
