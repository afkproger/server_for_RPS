package ru.technolog.sorting_algorithms_server.entitys.data;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sa_test_arrays")
public class saTestArrayData implements IDataEntity {
    @Id
    @Column(name = "test_id")
    private Long testId;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    @Column(name = "test_array_data")
    private List<Double> testArrayData = new ArrayList<>();


    public List<Double> getTestArrayData() {
        return testArrayData;
    }

    public void setTestArrayData(List<Double> testArrayData) {
        this.testArrayData = testArrayData;
    }

    // методы пустые, интерфейс реализован для наследования
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getGUID() {
        return null;
    }

    @Override
    public Integer getVersion() {
        return null;
    }

    @Override
    public void upVersion() {

    }
}
