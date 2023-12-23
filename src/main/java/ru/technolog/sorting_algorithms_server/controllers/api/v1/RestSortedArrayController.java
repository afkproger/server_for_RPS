package ru.technolog.sorting_algorithms_server.controllers.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.technolog.sorting_algorithms_server.entitys.dto.dtoSortedArray;
import ru.technolog.sorting_algorithms_server.response.ApiResponse;
import ru.technolog.sorting_algorithms_server.services.saSortedArrayService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/sorted-array")
public class RestSortedArrayController {
    // Автоматическое внедрение зависимости сервиса для обработки отсортированных массивов
    @Autowired
    protected saSortedArrayService saSortedArrayService;

    // Обработка HTTP POST запроса для удаления отсортированного массива по индексу
    @PostMapping("/add")
    private ResponseEntity<ApiResponse> deleteArrayById(@RequestParam Long sortedArrayId) {
        return saSortedArrayService.deleteArray(sortedArrayId);
    }

    @PostMapping("/start/sorting")
    private ResponseEntity<ApiResponse> startSortingById(@RequestParam Long arrayId){
        return saSortedArrayService.startSoringById(arrayId);
    }

    @PostMapping("/get/once")
    private ResponseEntity<dtoSortedArray> getSortingArrayById(@RequestParam Long arrayId){
        return saSortedArrayService.getSortedArrayById(arrayId);
    }

    // Обработка HTTP GET запроса для получения всех данных о отсортированных массивах
    @GetMapping("/get/all")
    private ResponseEntity<List<dtoSortedArray>> getAllSortedArraysData() {
        return ResponseEntity.ok(saSortedArrayService.getAllSortedArrays());
    }
}

