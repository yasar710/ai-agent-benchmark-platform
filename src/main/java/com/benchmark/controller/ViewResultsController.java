package com.benchmark.controller;

import com.benchmark.dao.BenchmarkResultDao;
import com.benchmark.model.BenchmarkResult;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view-results")
public class ViewResultsController extends HttpServlet {

    private BenchmarkResultDao resultDao;

    @Override
    public void init() {
        resultDao = new BenchmarkResultDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BenchmarkResult> results = resultDao.getAllResults();
        request.setAttribute("resultsList", results);
        request.getRequestDispatcher("view-results.jsp").forward(request, response);
    }
}