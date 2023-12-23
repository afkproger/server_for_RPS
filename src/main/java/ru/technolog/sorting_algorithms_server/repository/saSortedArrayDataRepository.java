package ru.technolog.sorting_algorithms_server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.technolog.sorting_algorithms_server.entitys.data.saSortedArraysData;

import java.util.Optional;

public interface saSortedArrayDataRepository extends CrudRepository<saSortedArraysData,Long> {
}
