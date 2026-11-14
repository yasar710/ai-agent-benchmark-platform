package com.benchmark.model;

import jakarta.persistence.*;

@Entity
@Table(name = "benchmark_results")
public class BenchmarkResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Ek result kisi ek Agent ka hoga
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    // Ye result kis task ke liye hai
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String actualOutput; // Agent ne kya answer diya
    private boolean isSuccess;   // Pass hua ya Fail
    private long executionTimeMs; // Kitne milliseconds lage

    // Default Constructor (Hibernate ke liye zaroori)
    public BenchmarkResult() {}

    // Constructor
    public BenchmarkResult(Agent agent, Task task, String actualOutput, boolean isSuccess, long executionTimeMs) {
        this.agent = agent;
        this.task = task;
        this.actualOutput = actualOutput;
        this.isSuccess = isSuccess;
        this.executionTimeMs = executionTimeMs;
    }

    // Getters and Setters
    public int getId() { return id; }
    public Agent getAgent() { return agent; }
    public Task getTask() { return task; }
    public String getActualOutput() { return actualOutput; }
    public boolean isSuccess() { return isSuccess; }
    public long getExecutionTimeMs() { return executionTimeMs; }
}