package com.example.menu.controller;

import com.example.menu.FoodRequestDTO;
import com.example.menu.FoodResponseDTO;
import com.example.menu.food.Food;
import com.example.menu.food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }
    @GetMapping
    public List<FoodResponseDTO> getAll() {

        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
