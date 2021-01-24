package jpa.service;

import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteStudent {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, "SD01");

        if (student != null) {
            System.out.println("Data before deletion: " + student.getId() + " " + student.getName());
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } else {
            System.out.println("Data Not Found");
        }
        entityManager.close();
        emfactory.close();
    }
}
