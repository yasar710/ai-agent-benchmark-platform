<%@ page import="java.util.List" %>
<%@ page import="com.benchmark.model.Agent" %>
<%@ page import="com.benchmark.model.Task" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Run Benchmark</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <!-- Common Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-5">
        <div class="container">
            <a class="navbar-brand" href="index.html">Agent Benchmark Pro</a>
            <div class="collapse navbar-collapse">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="view-agents">Agents</a></li>
                    <li class="nav-item"><a class="nav-link" href="view-tasks">Tasks</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Benchmark Form -->
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card shadow-sm border-0">
                    <div class="card-header bg-warning text-dark">
                        <h4 class="mb-0">Test Run Karein (Benchmarking)</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="execute-benchmark" method="POST">

                            <!-- Agent Select Dropdown -->
                            <div class="mb-3">
                                <label class="form-label fw-bold">Select AI Agent:</label>
                                <select name="agentId" class="form-select" required>
                                    <option value="">-- Agent chunein --</option>
                                    <%
                                        List<Agent> agents = (List<Agent>) request.getAttribute("agentsList");
                                        if (agents != null) {
                                            for (Agent a : agents) {
                                    %>
                                        <option value="<%= a.getId() %>"><%= a.getName() %> (ID: <%= a.getId() %>)</option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>

                            <!-- Task Select Dropdown -->
                            <div class="mb-4">
                                <label class="form-label fw-bold">Select Task:</label>
                                <select name="taskId" class="form-select" required>
                                    <option value="">-- Task chunein --</option>
                                    <%
                                        List<Task> tasks = (List<Task>) request.getAttribute("tasksList");
                                        if (tasks != null) {
                                            for (Task t : tasks) {
                                    %>
                                        <option value="<%= t.getId() %>"><%= t.getPrompt() %></option>
                                    <%      }
                                        }
                                    %>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-warning w-100 fw-bold">Start Benchmark Test 🚀</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>