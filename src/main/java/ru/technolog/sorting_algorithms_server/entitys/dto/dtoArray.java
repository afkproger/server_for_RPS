package ru.technolog.sorting_algorithms_server.entitys.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * data transfer object для нашей сущности
 */
public class dtoArray implements IDTOEntity {
    private String arrayName;
    private Long arrayId;
    private LocalDateTime dateOfLoad;
    private Boolean statusOfLoad;

    public Boolean isStatusOfSorted() {
        return statusOfSorted;
    }

    public void setStatusOfSorted(boolean statusOfSorted) {
        this.statusOfSorted = statusOfSorted;
    }

    private Boolean statusOfSorted;

    public LocalDateTime getDateOfLoad() {
        return dateOfLoad;
    }

    public void setDateOfLoad(LocalDateTime dateOfLoad) {
        this.dateOfLoad = dateOfLoad;
    }

    private List<Double> arrayData = new ArrayList<>();


    public Boolean isStatusOfLoad() {
        return statusOfLoad;
    }

    public void setStatusOfLoad(Boolean statusOfLoad) {
        this.statusOfLoad = statusOfLoad;
    }

    public dtoArray() {

    }


    public String getArrayName() {
        return arrayName;
    }

    public void setArrayName(String arrayName) {
        this.arrayName = arrayName;
    }

    public Long getArrayId() {
        return arrayId;
    }

    public void setArrayId(Long arrayId) {
        this.arrayId = arrayId;
    }

    public List<Double> getArrayData() {
        return arrayData;
    }

    public void setArrayData(List<Double> arrayData) {
        this.arrayData = arrayData;
    }
}
