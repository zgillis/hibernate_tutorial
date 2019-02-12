package com.zgillis.hibernatut.app;

import com.zgillis.hibernatut.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Create the EntityManager using persistence.xml
        EntityManager entityManager = Persistence.createEntityManagerFactory("person-unit")
                .createEntityManager();

        // Get and begin a transaction
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // Create Person object to be persisted
        Person person = new Person("Robert", "Sagat", "bsagat@celebmail.com");
        entityManager.persist(person);
        transaction.commit();
        entityManager.close();
        System.out.println("Person created and stored!");
    }
}
