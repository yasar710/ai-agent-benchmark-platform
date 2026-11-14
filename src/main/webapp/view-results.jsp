<%@ page import="java.util.List" %>
<%@ page import="com.benchmark.model.BenchmarkResult" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Benchmark Results</title>
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
                    <li class="nav-item"><a class="nav-link active" href="view-results">Results</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <div class="d-flex justify-content-between align-items-center mb-4">
            <h2 class="text-primary">🏆 Benchmark Leaderboard</h2>
            <a href="prepare-benchmark" class="btn btn-warning fw-bold">Run New Test</a>
        </div>

        <div class="card shadow-sm border-0">
            <div class="card-body p-0">
                <table class="table table-striped table-hover mb-0">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Agent Name</th>
                            <th>Task Prompt</th>
                            <th>Actual Output</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<BenchmarkResult> results = (List<BenchmarkResult>) request.getAttribute("resultsList");
                            if (results != null && !results.isEmpty()) {
                                for (BenchmarkResult r : results) {
                        %>
                        <tr>
                            <td><%= r.getId() %></td>
                            <!-- Hibernate ki power: ID se direct Object ki properties access ho rahi hain -->
                            <td class="fw-bold"><%= r.getAgent().getName() %></td>
                            <td><%= r.getTask().getPrompt() %></td>
                            <td><%= r.getActualOutput() %></td>
                            <td>
                                <% if(r.isSuccess()) { %>
                                    <span class="badge bg-success">PASS</span>
                                <% } else { %>
                                    <span class="badge bg-danger">FAIL</span>
                                <% } %>
                            </td>
                        </tr>
                        <%
                                }
                            } else {
                        %>
                            <tr><td colspan="5" class="text-center py-4">Koi results nahi mile! Pehle ek test run karein.</td></tr>
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