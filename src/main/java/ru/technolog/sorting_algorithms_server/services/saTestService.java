package ru.technolog.sorting_algorithms_server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.technolog.sorting_algorithms_server.calcs.sorting.TreeSort;
import ru.technolog.sorting_algorithms_server.entitys.data.saSortedArraysData;
import ru.technolog.sorting_algorithms_server.entitys.data.saTestArrayData;
import ru.technolog.sorting_algorithms_server.entitys.data.saTestSortedArrayData;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoArray;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoTestMessage;
import ru.technolog.sorting_algorithms_server.repository.saArrayDataRepository;
import ru.technolog.sorting_algorithms_server.repository.saSortedArrayDataRepository;
import ru.technolog.sorting_algorithms_server.repository.saTestArrayDataRepository;
import ru.technolog.sorting_algorithms_server.repository.saTestSortedArrayDataRepository;
import ru.technolog.sorting_algorithms_server.response.ApiResponse;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class saTestService {
    @Autowired
    private saTestArrayDataRepository testArrayDataRepository;
    @Autowired
    private saTestSortedArrayDataRepository testSortedArrayDataRepository;
    private final static int ACCUMARRAYS = 10;
    // генерация данных

    public ResponseEntity<dtoTestMessage> testFor100Array() {
        try {
            for (long i = 1L; i <= 100L; i++) {
                List<Double> testArray = generateRandomDoubleList(ACCUMARRAYS);
                if (testArray.isEmpty()) {
                    return ResponseEntity.status(402).body(new dtoTestMessage(
                            "Тест на добавления 100 массивов",
                            false,
                            "Данный массив пустой"
                    ));
                }

                saTestArrayData saTestArrayData = new saTestArrayData();
                saTestArrayData.setTestId(i);
                saTestArrayData.setTestArrayData(testArray);

                testArrayDataRepository.save(saTestArrayData);

                // В этом методе тоже может быть ошибка
                if (!startSortedAndSaveArray(testArray, i)) {
                    // Если метод возвращает false, значит произошла ошибка
                    return ResponseEntity.badRequest().body(new dtoTestMessage(
                            "Тест на сохранения 100 массивов",
                            false,
                            "Ошибка: не удалось сохранить отсортированный массив"
                    ));
                }
            }
            if (deleteAllData(testArrayDataRepository) && deleteAllData(testSortedArrayDataRepository)) {
                return ResponseEntity.ok(new dtoTestMessage(
                        "100 массивов удалилось",
                        true,
                        "Тест прошёл"
                ));
            } else {
                return ResponseEntity.badRequest().body(new dtoTestMessage(
                        "Тест на удаления 100 массивов",
                        false,
                        "Ошибка: не удалось удалить все данные из таблиц"
                )) ;
            }
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new dtoTestMessage(
                    "Тест не прошёл",
                    false,
                    "Тест не прошёл"
            ));
        }
    }

    public ResponseEntity<dtoTestMessage> testFor1000Array() {
        try {
            for (long i = 1L; i <= 1000L; i++) {
                List<Double> testArray = generateRandomDoubleList(ACCUMARRAYS);
                if (testArray.isEmpty()) {
                    return ResponseEntity.status(402).body(new dtoTestMessage(
                            "Тест на добавления 1000 массивов",
                            false,
                            "Данный массив пустой"
                    ));
                }

                saTestArrayData saTestArrayData = new saTestArrayData();
                saTestArrayData.setTestId(i);
                saTestArrayData.setTestArrayData(testArray);

                testArrayDataRepository.save(saTestArrayData);

                // В этом методе тоже может быть ошибка
                if (!startSortedAndSaveArray(testArray, i)) {
                    // Если метод возвращает false, значит произошла ошибка
                    return ResponseEntity.badRequest().body(new dtoTestMessage(
                            "Тест на сохранения 1000 массивов",
                            false,
                            "Ошибка: не удалось сохранить отсортированный массив"
                    ));
                }
            }
            if (deleteAllData(testArrayDataRepository) && deleteAllData(testSortedArrayDataRepository)) {
                return ResponseEntity.ok(new dtoTestMessage(
                        "1000 массивов удалилось",
                        true,
                        "Тест прошёл"
                ));
            } else {
                return ResponseEntity.badRequest().body(new dtoTestMessage(
                        "Тест на удаления 1000 массивов",
                        false,
                        "Ошибка: не удалось удалить все данные из таблиц"
                )) ;
            }
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new dtoTestMessage(
                    "Тест не прошёл",
                    false,
                    "Тест не прошёл"
            ));
        }
    }


    public ResponseEntity<dtoTestMessage> testFor10000Array() {
        try {
            for (long i = 1L; i <= 10000L; i++) {
                List<Double> testArray = generateRandomDoubleList(ACCUMARRAYS);
                if (testArray.isEmpty()) {
                    return ResponseEntity.status(402).body(new dtoTestMessage(
                            "Тест на добавления 10000 массивов",
                            false,
                            "Данный массив пустой"
                    ));
                }

                saTestArrayData saTestArrayData = new saTestArrayData();
                saTestArrayData.setTestId(i);
                saTestArrayData.setTestArrayData(testArray);

                testArrayDataRepository.save(saTestArrayData);

                // В этом методе тоже может быть ошибка
                if (!startSortedAndSaveArray(testArray, i)) {
                    // Если метод возвращает false, значит произошла ошибка
                    return ResponseEntity.badRequest().body(new dtoTestMessage(
                            "Тест на сохранения 10000 массивов",
                            false,
                            "Ошибка: не удалось сохранить отсортированный массив"
                    ));
                }
            }
            if (deleteAllData(testArrayDataRepository) && deleteAllData(testSortedArrayDataRepository)) {
                return ResponseEntity.ok(new dtoTestMessage(
                        "10000 массивов удалилось",
                        true,
                        "Тест прошёл"
                ));
            } else {
                return ResponseEntity.badRequest().body(new dtoTestMessage(
                        "Тест на удаления 10000 массивов",
                        false,
                        "Ошибка: не удалось удалить все данные из таблиц"
                )) ;
            }
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(new dtoTestMessage(
                    "Тест не прошёл",
                    false,
                    "Тест не прошёл"
            ));
        }
    }

    private boolean startSortedAndSaveArray(List<Double> testArray, Long index) {
        try {
            saTestSortedArrayData saTestSortedArrayData = new saTestSortedArrayData();
            TreeSort<Double> treeSort = new TreeSort<>();
            saTestSortedArrayData.setTestSortedArrayId(index);
            saTestSortedArrayData.setTestArrayData(treeSort.sort(testArray));
            testSortedArrayDataRepository.save(saTestSortedArrayData);
            return true; // Успешно сохранено
        } catch (Exception e) {
            e.printStackTrace(); // Выводите или обрабатывайте ошибку по вашему усмотрению
            return false; // Произошла ошибка
        }
    }


    public static List<Double> generateRandomDoubleList(int size) {
        List<Double> randomDoubleList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            double randomValue = random.nextDouble();
            randomDoubleList.add(randomValue);
        }

        return randomDoubleList;
    }

    private boolean deleteAllData(CrudRepository<?, ?> repository) {
        try {
            repository.deleteAll();
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Выводите или обрабатывайте ошибку по вашему усмотрению
            return false;
        }
    }

}
