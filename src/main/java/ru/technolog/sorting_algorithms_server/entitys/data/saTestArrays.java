package ru.technolog.sorting_algorithms_server.entitys.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sa_tests_arrays")
public class saTestArrays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_array_id")
    private Long testArrayId;

    @Column(name = "test_array_name")
    private String testArrayName;

    @Column(name = "test_array_data")
    private List<Double> testArrayData = new ArrayList<>();

    @Column(name = "test_status_of_load")
    private Boolean testStatusOfLoad;

    @Column(name = "test_status_of_sorted")
    private Boolean testStatusOfSorted;

    @Column(name = "test_date_of_load")
    private LocalDateTime testDateOfLoad;

    public Long getTestArrayId() {
        return testArrayId;
    }

    public void setTestArrayId(Long testArrayId) {
        this.testArrayId = testArrayId;
    }

    public String getTestArrayName() {
        return testArrayName;
    }

    public void setTestArrayName(String testArrayName) {
        this.testArrayName = testArrayName;
    }

    public List<Double> getTestArrayData() {
        return testArrayData;
    }

    public void setTestArrayData(List<Double> testArrayData) {
        this.testArrayData = testArrayData;
    }

    public Boolean getTestStatusOfLoad() {
        return testStatusOfLoad;
    }

    public void setTestStatusOfLoad(Boolean testStatusOfLoad) {
        this.testStatusOfLoad = testStatusOfLoad;
    }

    public Boolean getTestStatusOfSorted() {
        return testStatusOfSorted;
    }

    public void setTestStatusOfSorted(Boolean testStatusOfSorted) {
        this.testStatusOfSorted = testStatusOfSorted;
    }

    public LocalDateTime getTestDateOfLoad() {
        return testDateOfLoad;
    }

    public void setTestDateOfLoad(LocalDateTime testDateOfLoad) {
        this.testDateOfLoad = testDateOfLoad;
    }
}
