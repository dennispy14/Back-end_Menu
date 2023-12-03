package com.example.menu.api.controller;

import com.example.menu.api.dtos.FoodRequestDTO;
import com.example.menu.api.dtos.FoodResponseDTO;
import com.example.menu.modelos.entity.Food;
import com.example.menu.modelos.repository.FoodRepository;
import com.example.menu.modelos.sevices.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodService service;
    @Autowired
    private FoodRepository repository;
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        service.insert(data);
    }
    @GetMapping
    public List<FoodResponseDTO> findAll() {
        return service.getAll();
    }
}
