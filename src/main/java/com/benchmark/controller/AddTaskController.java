package com.benchmark.controller;

import com.benchmark.dao.TaskDao;
import com.benchmark.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Ye wo URL hai jahan form submit hoga
@WebServlet("/add-task")
public class AddTaskController extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = new TaskDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Form se data nikala
        String prompt = request.getParameter("prompt");
        String expectedOutput = request.getParameter("expectedOutput");

        // 2. Naya Task object banaya
        Task newTask = new Task(prompt, expectedOutput);

        // 3. DAO ko call karke MySQL mein save kiya
        taskDao.saveTask(newTask);

        // 4. Success message dikhaya
        response.setContentType("text/plain");
        // Save hone ke baad seedha View Tasks page par bhej do
        response.sendRedirect("view-tasks");
    }
}