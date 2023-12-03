package com.example.menu.modelos.repository;

import com.example.menu.modelos.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
