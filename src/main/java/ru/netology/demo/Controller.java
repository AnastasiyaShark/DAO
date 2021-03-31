package ru.netology.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class Controller {

    private final Repository_For_Working_With_The_Database repository;

    public Controller(Repository_For_Working_With_The_Database repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getListProductName(String name) throws IOException {
        return repository.getProductByName(name);
    }
}
