<%@ page import="java.util.List" %>
<%@ page import="com.benchmark.model.Task" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tasks Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Common Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="index.html">Agent Benchmark Pro</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="view-agents">Agents</a></li>
                    <li class="nav-item"><a class="nav-link active" href="view-tasks">Tasks</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Main Content -->
    <div class="container mt-5">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-primary">Benchmark Tasks</h2>
            <a href="add-task.html" class="btn btn-success">+ Naya Task Add Karein</a>
        </div>

        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <table class="table table-striped table-hover mb-0">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Task Prompt</th>
                            <th>Expected Output</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<Task> tasks = (List<Task>) request.getAttribute("tasksList");
                            if (tasks != null && !tasks.isEmpty()) {
                                for (Task task : tasks) {
                        %>
                        <tr>
                            <td><%= task.getId() %></td>
                            <td class="fw-bold"><%= task.getPrompt() %></td>
                            <td><span class="badge bg-info text-dark"><%= task.getExpectedOutput() %></span></td>
                        </tr>
                        <%
                                }
                            } else {
                        %>
                            <tr><td colspan="3" class="text-center py-4 text-muted">Koi task nahi mila!</td></tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>