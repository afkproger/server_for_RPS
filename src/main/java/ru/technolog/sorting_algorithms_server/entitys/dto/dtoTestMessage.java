package ru.technolog.sorting_algorithms_server.entitys.dto;

public class dtoTestMessage implements IDTOEntity {
    private String testName;
    private Boolean testStatus;

    public dtoTestMessage(String testName, Boolean testStatus, String testDescription) {
        this.testName = testName;
        this.testStatus = testStatus;
        this.testDescription = testDescription;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Boolean getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Boolean testStatus) {
        this.testStatus = testStatus;
    }

    public String getTestDescription() {
        return testDescription;
    }

    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }

    private String testDescription;
}
