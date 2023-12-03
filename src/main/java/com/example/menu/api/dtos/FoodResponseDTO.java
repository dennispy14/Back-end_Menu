package com.example.menu.api.dtos;

import com.example.menu.modelos.entity.Food;

public record FoodResponseDTO (Long id, String title, String image, Integer price){
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
    }


}
