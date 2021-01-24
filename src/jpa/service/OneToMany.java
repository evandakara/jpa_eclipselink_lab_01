package jpa.service;

import jpa.model.onetomany.Department;
import jpa.model.onetomany.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        EntityManagerFactory emfactory = Persistence
                .createEntityManagerFactory("eclipseLinkJPA");
        EntityManager entityManager = emfactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee1 = new Employee();
        employee1.setName("Evan");
        employee1.setSalary(BigDecimal.valueOf(2000));
        employee1.setAddress("adasfdsa");

        Employee employee2 = new Employee();
        employee2.setName("evna");
        employee2.setSalary(BigDecimal.valueOf(9000));
        employee2.setAddress("adasfdasdasasa");

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);

        Department department = new Department();
        department.setDepartmentName("IT");
        department.setEmployees(employeeList);

        entityManager.persist(department);

        entityManager.getTransaction().commit();
        entityManager.close();
        emfactory.close();
    }
}
