package com.benchmark.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TEXT")
    private String prompt;

    @Column(name = "expected_output", columnDefinition = "TEXT")
    private String expectedOutput;

    public Task(){

    }

    public Task(String prompt, String expectedOutput) {
        this.prompt = prompt;
        this.expectedOutput = expectedOutput;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

}
