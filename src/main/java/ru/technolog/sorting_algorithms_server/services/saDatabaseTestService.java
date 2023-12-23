package ru.technolog.sorting_algorithms_server.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technolog.sorting_algorithms_server.calcs.sorting.TreeSort;
import ru.technolog.sorting_algorithms_server.entitys.data.saArraysData;
import ru.technolog.sorting_algorithms_server.entitys.data.saTestArrays;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoTestMessage;
import ru.technolog.sorting_algorithms_server.repository.saTestDataRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class saDatabaseTestService {

    private final saTestDataRepository saTestDataRepository;

    public saDatabaseTestService(saTestDataRepository saTestDataRepository) {
        this.saTestDataRepository = saTestDataRepository;
    }

    public ResponseEntity<dtoTestMessage> addArraysToDatabase(String testName, int arrayCount) {
        try {
            List<saTestArrays> arrays = generateRandomArrays(arrayCount);
            saTestDataRepository.saveAll(arrays);
            return ResponseEntity.ok(new dtoTestMessage(testName, true, "Добавление успешно"));
        } catch (Exception e) {
            return ResponseEntity.ok(new dtoTestMessage(testName, false, "Ошибка при добавлении: " + e.getMessage()));
        }
    }

    public ResponseEntity<dtoTestMessage> sortRandomArrays(String testName, int arrayCount) {
        try {
            List<saTestArrays> arrays = generateRandomArrays(arrayCount);
            TreeSort<Double> treeSort = new TreeSort<>();
            for (saTestArrays array : arrays) {
                array.setTestArrayData(treeSort.sort(array.getTestArrayData()));
            }
            saTestDataRepository.saveAll(arrays);
            return ResponseEntity.ok(new dtoTestMessage(testName, true, "Сортировка успешна"));
        } catch (Exception e) {
            return ResponseEntity.ok(new dtoTestMessage(testName,false, "Ошибка при сортировке: " + e.getMessage()));
        }
    }

    public ResponseEntity<dtoTestMessage> clearDatabase(String testName, int arrayCount) {
        try {
            saTestDataRepository.deleteAll();
            return ResponseEntity.ok(new dtoTestMessage(testName, true, "Очистка базы успешна"));
        } catch (Exception e) {
            return ResponseEntity.ok(new dtoTestMessage(testName, false, "Ошибка при очистке базы: " + e.getMessage()));
        }
    }

    private List<saTestArrays> generateRandomArrays(int arrayCount) {
        List<saTestArrays> arrays = new ArrayList<>();

        for (int i = 0; i < arrayCount; i++) {
            saTestArrays array = new saTestArrays();
            array.setTestArrayData(generateRandomArray());
            array.setTestArrayName("Array" + i);
            array.setTestStatusOfLoad(true);
            array.setTestStatusOfSorted(false);
            array.setTestDateOfLoad(LocalDateTime.now());
            arrays.add(array);
        }

        return arrays;
    }

    private List<Double> generateRandomArray() {
        List<Double> array = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < random.nextInt(28); i++) {
            array.add(random.nextDouble());
        }

        return array;
    }
}
