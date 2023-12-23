package ru.technolog.sorting_algorithms_server.controllers.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoArray;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoSortedArray;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoTestMessage;
import ru.technolog.sorting_algorithms_server.response.ApiResponse;
import ru.technolog.sorting_algorithms_server.services.saLoadArrayService;
import ru.technolog.sorting_algorithms_server.services.saTestService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/tests-status")
public class RestTestController {
    // Обработка HTTP GET запроса для получения всех данных об отсортированных массивах
    @Autowired
    private saTestService saTestService;
    // Обработка HTTP GET запроса для запуска тестов на 100 массивов
    @GetMapping("test1")
    private ResponseEntity<dtoTestMessage> testFor100arrays() {
        return saTestService.testFor100Array();
    }

    @GetMapping("test2")
    private ResponseEntity<dtoTestMessage> testFor1000arrays() {
        return saTestService.testFor1000Array();
    }


    @GetMapping("test3")
    private ResponseEntity<dtoTestMessage> testFor10000arrays() {
        return saTestService.testFor10000Array();
    }

}
