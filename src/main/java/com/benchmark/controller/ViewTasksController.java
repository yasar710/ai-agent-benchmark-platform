package com.benchmark.controller;

import com.benchmark.dao.TaskDao;
import com.benchmark.model.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view-tasks")
public class ViewTasksController extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Task> tasks = taskDao.getAllTasks();
        request.setAttribute("tasksList", tasks);
        request.getRequestDispatcher("view-tasks.jsp").forward(request, response);
    }
}