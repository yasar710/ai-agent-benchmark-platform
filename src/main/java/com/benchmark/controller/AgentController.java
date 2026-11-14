package com.benchmark.controller;

import com.benchmark.dao.AgentDao;
import com.benchmark.model.Agent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Ye URL hai jispar frontend data bhejega
@WebServlet("/add-agent")
public class AgentController extends HttpServlet {

    private AgentDao agentDao;

    @Override
    public void init() {
        // Jab servlet start hoga toh DAO initialize ho jayega
        agentDao = new AgentDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Frontend ya Postman se aane wala data (name aur apiUrl) nikalna
        String name = request.getParameter("name");
        String apiUrl = request.getParameter("apiUrl");

        // 2. Naya Agent object banana
        Agent newAgent = new Agent(name, apiUrl);

        // 3. DAO ka use karke usko MySQL mein save karna
        agentDao.saveAgent(newAgent);

        // 4. Frontend par success message print karna
        response.setContentType("text/plain");
        // Save hone ke baad seedha View Agents page par bhej do
        response.sendRedirect("view-agents");
    }
}