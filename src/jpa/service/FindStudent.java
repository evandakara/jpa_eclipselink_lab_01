package jpa.service;

import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindStudent {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, 1);
        System.out.println(" " + student.getId() + " " + student.getName());

        entityManager.close();
        emfactory.close();
    }

}
