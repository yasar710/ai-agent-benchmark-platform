package com.benchmark.dao;

import com.benchmark.model.Agent;
import com.benchmark.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AgentDao {

    public void saveAgent(Agent agent) {
        // Step 1 & 2 (Config/Factory) util se aa gaya

        // Step 3: Session khola
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Step 4: Transaction start kiya
        Transaction transaction = session.beginTransaction();

        try {
            // Step 5: Data persist kiya
            session.persist(agent);

            // Step 6: Commit kiya (Save)
            transaction.commit();
            System.out.println("DAO ne Agent save kar diya: " + agent.getName());

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Agar kuch fail hua toh changes wapas
            }
            e.printStackTrace();
        } finally {
            // Step 7: Session clear aur close kiya
            session.clear();
            session.close();
        }
    }


    // Naya method saare agents ko database se laane ke liye
    public java.util.List<Agent> getAllAgents() {
        // Step 1: Session aur Transaction start
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        java.util.List<Agent> agentList = null;

        try {
            // Step 2: Hibernate Query Language (HQL) se saara data nikalna
            // Yahan hum table ka nahi, Java class ka naam (Agent) likhte hain
            agentList = session.createQuery("from Agent", Agent.class).list();

            // Step 3: Commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Step 4: Clear aur Close
            session.clear();
            session.close();
        }
        return agentList;
    }
}