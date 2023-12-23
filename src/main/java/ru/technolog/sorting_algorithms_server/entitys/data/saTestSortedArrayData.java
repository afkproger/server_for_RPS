package ru.technolog.sorting_algorithms_server.entitys.data;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sa_test_sorted_arrays")
public class saTestSortedArrayData implements IDataEntity {

    @Id
    @Column(name = "test_sorted_array_id")
    private Long testSortedArrayId;


    @Column(name = "test_sorted_array")
    private List<Double> testArrayData = new ArrayList<>();


    public Long getTestSortedArrayId() {
        return testSortedArrayId;
    }

    public void setTestSortedArrayId(Long testSortedArrayId) {
        this.testSortedArrayId = testSortedArrayId;
    }

    public List<Double> getTestArrayData() {
        return testArrayData;
    }

    public void setTestArrayData(List<Double> testArrayData) {
        this.testArrayData = testArrayData;
    }
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
