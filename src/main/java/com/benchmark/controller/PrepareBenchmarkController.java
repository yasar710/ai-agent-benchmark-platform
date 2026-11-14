package com.benchmark.controller;

import com.benchmark.dao.AgentDao;
import com.benchmark.dao.TaskDao;
import com.benchmark.model.Agent;
import com.benchmark.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Ye URL form open karne ke liye hai
@WebServlet("/prepare-benchmark")
public class PrepareBenchmarkController extends HttpServlet {

    private AgentDao agentDao;
    private TaskDao taskDao;

    @Override
    public void init() {
        agentDao = new AgentDao();
        taskDao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Dono list database se nikali
        List<Agent> agents = agentDao.getAllAgents();
        List<Task> tasks = taskDao.getAllTasks();

        // JSP page ke liye attributes set kiye
        request.setAttribute("agentsList", agents);
        request.setAttribute("tasksList", tasks);

        // Form wale page par bhej diya
        request.getRequestDispatcher("run-benchmark.jsp").forward(request, response);
    }
}