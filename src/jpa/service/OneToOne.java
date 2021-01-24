package jpa.service;

import jpa.model.manytoone.Student;
import jpa.model.onetoone.Identity;
import jpa.model.onetoone.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOne {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

//        Identity identity1 = new Identity();
//
//        entityManager.persist(identity1);
//
//        Person person1 = new Person();
//        person1.setName("Budi");
//        person1.setAge(75);
//        person1.setIdentity(identity1);
//
//        Person person2 = new Person();
//        person2.setName("Evnadas");
//        person2.setAge(76);
//        person2.setIdentity(identity1);
//
//        entityManager.persist(person1);
//        entityManager.persist(person2);


//        identity1.setPerson(person1);
//        identity1.setPerson(person2);

//        Person person = entityManager.find(Person.class, 352L);
//        Identity identity = entityManager.find(Identity.class, 351L);
//        System.out.println(person);
//        System.out.println(identity);
//
//        person.setIdentity(identity);
        entityManager.getTransaction().commit();

        entityManager.close();
        emfactory.close();
    }
}
