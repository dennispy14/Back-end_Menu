package com.example.menu.serivices;

import com.example.menu.api.dtos.FoodRequestDTO;
import com.example.menu.api.dtos.FoodResponseDTO;
import com.example.menu.modelos.entity.Food;
import com.example.menu.modelos.repository.FoodRepository;
import com.example.menu.modelos.sevices.FoodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class FoodServiceTest {
    @Mock
    private FoodRepository repository;

    @Mock
    private FoodRequestDTO foodRequestDTO;

    private Food food;

    @InjectMocks
    private FoodService service;

    @Test
    public void deveGravarFoodComSucesso(){
        service.insert(foodRequestDTO);
        Food food = new Food(foodRequestDTO);
        verify(repository, times(1)).save(food);
    }

    @Test
    public void deveTrazerTodosItensFood(){
        List<FoodResponseDTO> food = service.getAll();
        verify(repository, times(1)).findAll();
    }
}
