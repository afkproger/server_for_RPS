package ru.technolog.sorting_algorithms_server.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.technolog.sorting_algorithms_server.entitys.data.saArraysData;

import java.util.Optional;

// для работы с изменением данных в БД
@Repository
public interface saArrayDataRepository extends CrudRepository<saArraysData,Long> {
}
