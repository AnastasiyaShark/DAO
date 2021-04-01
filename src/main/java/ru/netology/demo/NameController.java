package ru.netology.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class NameController {

    private final NameRepository repository;

    public NameController(NameRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/products/fetch-product")
    public String getListProductName(String name) throws IOException {
        return repository.getProductByName(name);
    }
}
