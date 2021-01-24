package jpa.service;

import jpa.model.manytoone.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateStudent {
    public static void main(String[] args) {
        // define entity manager that we want to use when open connection entity
        // manager factory
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");

        EntityManager entityManager = emfactory.createEntityManager();

        // open transaction
        entityManager.getTransaction().begin();

        // set object
        Student student = new Student();
        student.setName("Bunga");
        student.setAge(17);
        student.setAddress("Bekasi");

        Student student2 = new Student();
        student2.setName("Evan");
        student2.setAge(34);
        student2.setAddress("Tebet");

        // persist data into database
        // entityManager.persist(student);
        entityManager.persist(student2);

        // commit this transaction
        entityManager.getTransaction().commit();

        // close entity manager connection
        entityManager.close();

        // close entity manager factory connection
        emfactory.close();
    }
}
