//                                AgentDao mai check kar rhe hai
//package com.benchmark;
//
//import com.benchmark.model.Agent;
//import com.benchmark.model.Task;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class Main {
//    public static void main(String[] args) {
//
//        System.out.println("Process start ho raha hai...");
//
//        // Step 1 & 2: Configuration aur Session Factory
//        Configuration configuration = new Configuration();
//        configuration.configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        // Step 3 & 4: Session aur Transaction
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//
//        // ---------------------------------------------------------
//        // 1. Naya Agent banaya aur persist kiya
//        Agent agent2 = new Agent("MathAgent", "http://localhost:9090/api/math");
//        session.persist(agent2);
//        System.out.println("Agent queue mein lag gaya...");
//
//        // 2. Naya Task banaya aur persist kiya
//        Task task1 = new Task("Calculate 25 * 48", "1200");
//        session.persist(task1);
//        System.out.println("Task queue mein lag gaya...");
//        // ---------------------------------------------------------
//
//        // Step 6: Transaction Commit (Ab dono ek sath database mein save ho jayenge)
//        transaction.commit();
//
//        System.out.println("Success! Agent aur Task dono database mein save ho gaye.");
//
//        // Step 7 & 8: Session aur Factory Close
//        session.clear();
//        session.close();
//        sessionFactory.close();
//    }
//}


//                                    Task wale DAO ko check kar rhe hai



package com.benchmark;

import com.benchmark.dao.AgentDao;
import com.benchmark.dao.TaskDao;
import com.benchmark.model.Agent;
import com.benchmark.model.Task;

public class Main {
    public static void main(String[] args) {

        // 1. AgentDao test karna
        Agent newAgent = new Agent("DaoAgent", "http://localhost:8085/api/test");
        AgentDao agentDao = new AgentDao();
        agentDao.saveAgent(newAgent);

        // 2. TaskDao test karna
        Task newTask = new Task("Capital of UP?", "Lucknow");
        TaskDao taskDao = new TaskDao();
        taskDao.saveTask(newTask);

        System.out.println("Dono DAOs successfully test ho gaye!");
    }
}