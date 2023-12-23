package ru.technolog.sorting_algorithms_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technolog.sorting_algorithms_server.calcs.sorting.TreeSort;
import ru.technolog.sorting_algorithms_server.entitys.data.saArraysData;
import ru.technolog.sorting_algorithms_server.entitys.data.saSortedArraysData;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoSortedArray;
import ru.technolog.sorting_algorithms_server.repository.saArrayDataRepository;
import ru.technolog.sorting_algorithms_server.repository.saSortedArrayDataRepository;
import ru.technolog.sorting_algorithms_server.response.ApiResponse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


@Service
public class saSortedArrayService {
    // Автоматическое внедрение зависимости репозитория для работы с отсортированными массивами
    @Autowired
    private saSortedArrayDataRepository sortedArrayDataRepository;

    @Autowired
    private saArrayDataRepository arrayDataRepository;

    // Метод для удаления отсортированного массива по его идентификатору
    public ResponseEntity<ApiResponse> deleteArray(Long sortedArrayId) {
        // Пытаемся найти отсортированный массив по его идентификатору
        Optional<saSortedArraysData> saSortedArraysDataOptional = sortedArrayDataRepository.findById(sortedArrayId);

        if (saSortedArraysDataOptional.isPresent()) {
            // Если массив найден, удаляем его из репозитория
            sortedArrayDataRepository.deleteById(sortedArrayId);
            return ResponseEntity.ok(new ApiResponse("Удаление успешно"));
        } else {
            // Если массив не найден, возвращаем ошибку 404 с соответствующим сообщением
            return ResponseEntity.status(404).body(new ApiResponse("Этот массив не существует"));
        }
    }

    // Метод для получения списка всех отсортированных массивов в виде DTO
    public List<dtoSortedArray> getAllSortedArrays() {
        // Получаем список всех отсортированных массивов из репозитория
        List<saSortedArraysData> sortedArraysList = StreamSupport.stream(sortedArrayDataRepository.findAll().spliterator(), true).toList();

        // Преобразуем список отсортированных массивов в список DTO
        return sortedArraysList.stream()
                .map(this::mapToSortedArraysDTO)
                .toList();
    }

    // Метод для преобразования объекта saSortedArraysData в объект dtoSortedArray
    public dtoSortedArray mapToSortedArraysDTO(saSortedArraysData saSortedArraysData) {
        dtoSortedArray sortedArraysDTO = new dtoSortedArray();
        sortedArraysDTO.setArrayData(saSortedArraysData.getArrayData());
        sortedArraysDTO.setSortedArrayId(saSortedArraysData.getSortedArrayId());
        sortedArraysDTO.setStatusOfSorted(saSortedArraysData.isStatusOfSorted());
        sortedArraysDTO.setSortedArrayName(saSortedArraysData.getSortedArrayName());
        sortedArraysDTO.setDateOfSorted(saSortedArraysData.getDateOfSorted());
        sortedArraysDTO.setTimeOfImpl(saSortedArraysData.getTimeOfImpl());
        return sortedArraysDTO;
    }

    public ResponseEntity<ApiResponse> startSoringById(Long arrayId) {
        Optional<saArraysData> saArraysDataOptional = arrayDataRepository.findById(arrayId);
        if (saArraysDataOptional.isPresent()) {
            saArraysData saArraysData = saArraysDataOptional.get();
            saSortedArraysData saSortedArraysData = new saSortedArraysData();
            TreeSort<Double> treeSort = new TreeSort<>();
            saSortedArraysData.setSortedArrayId(saArraysData.getArrayId());
            saSortedArraysData.setSortedArrayName(saArraysData.getArrayName());
            LocalDateTime startSorting = LocalDateTime.now();
            saSortedArraysData.setDateOfSorted(LocalDateTime.now());
            saSortedArraysData.setArrayData(treeSort.sort(saArraysData.getArrayData()));
            LocalDateTime endSorting = LocalDateTime.now();
            Duration sortingDuration = Duration.between(startSorting, endSorting);
            saSortedArraysData.setTimeOfImpl(sortingDuration);
            saSortedArraysData.setStatusOfSorted(true);
            sortedArrayDataRepository.save(saSortedArraysData);
            return ResponseEntity.ok(new ApiResponse("Сортировка прошла успешно"));

        } else {
            return ResponseEntity.status(404).body(new ApiResponse("Такого массива не существует!"));
        }
    }

    public ResponseEntity<dtoSortedArray> getSortedArrayById(Long arrayId) {
        Optional<saSortedArraysData> saSortedArraysDataOptional = sortedArrayDataRepository.findById(arrayId);
        if (saSortedArraysDataOptional.isPresent()) {
            saSortedArraysData saSortedArraysData = saSortedArraysDataOptional.get();
            return ResponseEntity.ok(mapToSortedArraysDTO(saSortedArraysData));
        }else{
            return ResponseEntity.status(404).body(null);
        }
    }
}
