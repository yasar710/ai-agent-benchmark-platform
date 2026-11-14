package com.benchmark.dao;

import com.benchmark.model.Task;
import com.benchmark.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TaskDao {

    public void saveTask(Task task) {
        // Step 3: Session khola (Step 1 & 2 HibernateUtil se background mein ho gaye)
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Step 4: Transaction start kiya
        Transaction transaction = session.beginTransaction();

        try {
            // Step 5: Data persist kiya
            session.persist(task);

            // Step 6: Commit kiya (Save)
            transaction.commit();
            System.out.println("TaskDao ne database mein Task save kar diya!");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Agar koi error aaye toh changes wapas le lo
            }
            e.printStackTrace();
        } finally {
            // Step 7: Session clear aur close kiya
            session.clear();
            session.close();
        }
    }


    // Saare tasks ko database se nikalne ke liye naya method
    public java.util.List<Task> getAllTasks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        java.util.List<Task> taskList = null;

        try {
            // "Task" class ka naam hai, HQL yahi use karta hai
            taskList = session.createQuery("from Task", Task.class).list();
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
        return taskList;
    }
}