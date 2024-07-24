package com.example.like_hero_to_zero;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CO2WerteDAO {
    private EntityManagerFactory emf;

    public CO2WerteDAO() {
        this.emf = Persistence.createEntityManagerFactory("default");
    }

    public List<CO2Werte> readAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CO2Werte> query = em.createQuery("SELECT c FROM CO2Werte c", CO2Werte.class);
        List<CO2Werte> results = query.getResultList();
        em.close();
        return results;
    }

    public List<CO2Werte> findByCountry(String country) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CO2Werte> query = em.createQuery("SELECT c FROM CO2Werte c WHERE c.country = :country ORDER BY c.year DESC", CO2Werte.class);
        query.setParameter("country", country);
        List<CO2Werte> results = query.getResultList();
        em.close();
        return results;
    }

    public void create(CO2Werte co2Werte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(co2Werte);
        em.getTransaction().commit();
        em.close();
    }

    public CO2Werte read(Long id) {
        EntityManager em = emf.createEntityManager();
        CO2Werte co2Werte = em.find(CO2Werte.class, id);
        em.close();
        return co2Werte;
    }

    public void update(CO2Werte co2Werte) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(co2Werte);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CO2Werte co2Werte = em.find(CO2Werte.class, id);
        if (co2Werte != null) {
            em.remove(co2Werte);
        }
        em.getTransaction().commit();
        em.close();
    }
}