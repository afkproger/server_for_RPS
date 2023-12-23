package ru.technolog.sorting_algorithms_server.repository;

import org.springframework.data.repository.CrudRepository;
import ru.technolog.sorting_algorithms_server.entitys.data.saTestArrays;

public interface saTestDataRepository extends CrudRepository<saTestArrays,Long> {
}
