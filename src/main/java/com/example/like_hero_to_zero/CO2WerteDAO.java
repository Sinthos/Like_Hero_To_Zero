package com.example.like_hero_to_zero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CO2WerteDAO {
    private EntityManagerFactory emf;

    public CO2WerteDAO() {
        emf = Persistence.createEntityManagerFactory("default");
    }

    public List<CO2Werte> findByCountry(String country) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CO2Werte> query = em.createQuery("SELECT c FROM CO2Werte c WHERE c.country = :country ORDER BY c.year DESC", CO2Werte.class);
        query.setParameter("country", country);
        return query.getResultList();
    }

    public void create(CO2Werte co2Werte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(co2Werte);
        em.getTransaction().commit();
        em.close();
    }
}