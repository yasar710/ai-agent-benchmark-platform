package com.benchmark.controller;

import com.benchmark.dao.AgentDao;
import com.benchmark.model.Agent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Ye URL hai jahan par tumhara dashboard khulega
@WebServlet("/view-agents")
public class ViewAgentsController extends HttpServlet {

    private AgentDao agentDao;

    @Override
    public void init() {
        agentDao = new AgentDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. DAO se MySQL ke saare agents mangwana
        List<Agent> agents = agentDao.getAllAgents();

        // 2. Is data ko ek attribute mein pack karna taaki frontend par bhej sakein
        request.setAttribute("agentsList", agents);

        // 3. Data ko 'view-agents.jsp' naam ke page par forward karna
        request.getRequestDispatcher("view-agents.jsp").forward(request, response);
    }
}