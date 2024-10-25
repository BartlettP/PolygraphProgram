package edu.au.cpsc.module7;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;

public class ScheduledPolygraph implements Serializable {
    public enum TestResult {
        INCONCLUSIVE, PASSED, FAILED
    }
    public enum TestType {
        Monitoring, Offense, History, Maintenance
    }

    private String patientName;
    private LocalDate scheduledTest;
    private LocalDate nextTest;
    private TestResult testResult;
    private TestType testType;

    public ScheduledPolygraph() {
        patientName = "";
        scheduledTest = LocalDate.now();
        nextTest = scheduledTest.plusDays(180);
        testResult = TestResult.PASSED;
        testType = TestType.Maintenance;
    }

    // Parameterized constructor
    public ScheduledPolygraph(String patientName, LocalDate scheduledTest, TestResult testResult) {
        this.patientName = patientName;
        this.scheduledTest = scheduledTest;
        this.nextTest = scheduledTest.plusDays(180);
        this.testResult = testResult;
        this.testType = testType;
    }

    // Getters and setters
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        if (patientName == null) {
            throw new IllegalArgumentException("Patient name cannot be null.");
        }
        this.patientName = patientName;
    }

    public LocalDate getScheduledTest() {
        return scheduledTest;
    }

    public void setScheduledTest(LocalDate scheduledTest) {
        if (scheduledTest == null) {
            throw new IllegalArgumentException("Scheduled test date cannot be null.");
        }
        this.scheduledTest = scheduledTest;
        this.nextTest = scheduledTest.plusDays(180);
    }

    public LocalDate getNextTest() {
        return nextTest;
    }

    public void setNextTest(LocalDate nextTest) {
        if (nextTest == null) {
            throw new IllegalArgumentException("Next test date cannot be null.");
        }
        this.nextTest = nextTest;
    }

    public TestResult getTestResult() {
        return testResult;
    }

    public void setTestResult(TestResult testResult) {
        if (testResult == null) {
            throw new IllegalArgumentException("Test result cannot be null.");
        }
        this.testResult = testResult;
    }
    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        if (testType == null) {
            throw new IllegalArgumentException("Test result cannot be null.");
        }
        this.testType = testType;
    }
}