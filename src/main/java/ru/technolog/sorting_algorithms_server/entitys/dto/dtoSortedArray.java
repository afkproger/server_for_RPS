package ru.technolog.sorting_algorithms_server.entitys.dto;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class dtoSortedArray implements IDTOEntity {
    private Long sortedArrayId;
    private String sortedArrayName;
    private LocalDateTime dateOfSorted;
    private Duration timeOfImpl;
    private boolean statusOfSorted;

    public LocalDateTime getDateOfSorted() {
        return dateOfSorted;
    }

    public void setDateOfSorted(LocalDateTime dateOfSorted) {
        this.dateOfSorted = dateOfSorted;
    }

    public Duration getTimeOfImpl() {
        return timeOfImpl;
    }

    public void setTimeOfImpl(Duration timeOfImpl) {
        this.timeOfImpl = timeOfImpl;
    }

    public String getSortedArrayName() {
        return sortedArrayName;
    }

    public void setSortedArrayName(String sortedArrayName) {
        this.sortedArrayName = sortedArrayName;
    }

    private List<Double> array_data = new ArrayList<>();

    public Long getSortedArrayId() {
        return sortedArrayId;
    }

    public void setSortedArrayId(Long sortedArrayId) {
        this.sortedArrayId = sortedArrayId;
    }

    public List<Double> getArray_data() {
        return array_data;
    }

    public void setArrayData(List<Double> arrayData) {
        this.array_data = arrayData;
    }

    public boolean isStatusOfSorted() {
        return statusOfSorted;
    }

    public void setStatusOfSorted(boolean statusOfSorted) {
        this.statusOfSorted = statusOfSorted;
    }
}
