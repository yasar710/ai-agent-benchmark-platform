package com.benchmark.dao;

import com.benchmark.model.BenchmarkResult;
import com.benchmark.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BenchmarkResultDao {

    public void saveResult(BenchmarkResult result) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(result); // Naya result MySQL mein save karega
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Saare results fetch karne ke liye
    public java.util.List<BenchmarkResult> getAllResults() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        java.util.List<BenchmarkResult> resultList = null;

        try {
            resultList = session.createQuery("from BenchmarkResult", BenchmarkResult.class).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.clear();
            session.close();
        }
        return resultList;
    }
}