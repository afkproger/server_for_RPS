package ru.technolog.sorting_algorithms_server.entitys.dto;

import java.util.List;

public class dtoTask implements IDTOEntity{
    private Long task_id;

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    private List<Double> array;
    private List<Double> sorted_array;



    public List<Double> getArray() {
        return array;
    }

    public void setArray(List<Double> array) {
        this.array = array;
    }

    public List<Double> getSorted_array() {
        return sorted_array;
    }

    public void setSorted_array(List<Double> sorted_array) {
        this.sorted_array = sorted_array;
    }
}
