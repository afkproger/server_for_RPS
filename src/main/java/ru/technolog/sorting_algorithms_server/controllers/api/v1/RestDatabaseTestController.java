package ru.technolog.sorting_algorithms_server.controllers.api.v1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.technolog.sorting_algorithms_server.entitys.dto.dtoTestMessage;
import ru.technolog.sorting_algorithms_server.services.saDatabaseTestService;

@RestController
@RequestMapping("/api/v1/database-tests")
public class RestDatabaseTestController {

    @Autowired
    private saDatabaseTestService databaseTestService;

    @GetMapping("/add-100-arrays")
    public ResponseEntity<dtoTestMessage> add100ArraysToDatabase() {
        System.out.println("работает тест");
        return databaseTestService.addArraysToDatabase("Тест добавления 100 массивов",100);
    }

    @GetMapping("/add-1000-arrays")
    public ResponseEntity<dtoTestMessage> add1000ArraysToDatabase() {
        return databaseTestService.addArraysToDatabase("Тест добавления 1000 массивов",1000);
    }

    @GetMapping("/add-10000-arrays")
    public ResponseEntity<dtoTestMessage> add10000ArraysToDatabase() {
        return databaseTestService.addArraysToDatabase("Тест добавления 1000 массивов",10000);
    }

    @GetMapping("/sort-100-arrays")
    public ResponseEntity<dtoTestMessage> sort100RandomArrays() {
        return databaseTestService.sortRandomArrays("Тест сортировки 100 массивов",100);
    }

    @GetMapping("/sort-1000-arrays")
    public ResponseEntity<dtoTestMessage> sort1000RandomArrays() {
        return databaseTestService.sortRandomArrays("Тест сортировки 1000 массивов",1000);
    }

    @GetMapping("/sort-10000-arrays")
    public ResponseEntity<dtoTestMessage> sort10000RandomArrays() {
        return databaseTestService.sortRandomArrays("Тест сортировки 10000 массивов",10000);
    }

    @GetMapping("/clear-database-100-arrays")
    public ResponseEntity<dtoTestMessage> clearDatabase100Arrays() {
        return databaseTestService.clearDatabase("Тест удаления 100 массивов",100);
    }

    @GetMapping("/clear-database-1000-arrays")
    public ResponseEntity<dtoTestMessage> clearDatabase1000Arrays() {
        return databaseTestService.clearDatabase("Тест удаления 1000 массивов",1000);
    }

    @GetMapping("/clear-database-10000-arrays")
    public ResponseEntity<dtoTestMessage> clearDatabase10000Arrays() {
        return databaseTestService.clearDatabase("Тест удаления 10000 массивов",10000);
    }
}
