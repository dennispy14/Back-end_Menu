package com.example.menu.api;

import com.example.menu.api.controller.FoodController;
import com.example.menu.api.dtos.FoodRequestDTO;
import com.example.menu.modelos.sevices.FoodService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.ActiveProfiles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class FoodControllerTest {

    @InjectMocks
    FoodController controller;
    @Mock
    private FoodService service;
    private MockMvc mockMvc;
    @Mock
    private FoodRequestDTO foodRequestDTO;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .alwaysDo(print())
                .build();
    }

    @Test
    public void deveAceitarRequisicaoEChamarOServiceInsertComSucesso() throws Exception {
        String foodJson = objectMapper.writeValueAsString(foodRequestDTO);
        mockMvc.perform(post("/food")
                .contentType(MediaType.APPLICATION_JSON)
                .content(foodJson))
                .andExpect(status().isOk());
    }
    @Test
    public void deveAceitarRequisicaoEChamarOServiceFindAllComSucesso() throws Exception {
        mockMvc.perform(get("/food")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
