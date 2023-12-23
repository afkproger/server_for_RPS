package ru.technolog.sorting_algorithms_server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.technolog.sorting_algorithms_server.entitys.data.saSortedArraysData;
import ru.technolog.sorting_algorithms_server.entitys.data.saTestArrayData;

public interface saTestArrayDataRepository extends CrudRepository<saTestArrayData,Long> {
}
