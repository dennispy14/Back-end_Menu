package com.example.menu.modelos.sevices;

import com.example.menu.api.dtos.FoodRequestDTO;
import com.example.menu.api.dtos.FoodResponseDTO;
import com.example.menu.modelos.entity.Food;
import com.example.menu.modelos.repository.FoodRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    private Food food;
    public void insert(FoodRequestDTO foodRequestDTO){
        food =new Food(foodRequestDTO);
        repository.save(food);
    }

    public List <FoodResponseDTO> getAll(){
        List <FoodResponseDTO> foodResponseDTO;
        foodResponseDTO = repository.findAll().stream().map(food -> new FoodResponseDTO(food)).toList();
        return foodResponseDTO;
    }
}
