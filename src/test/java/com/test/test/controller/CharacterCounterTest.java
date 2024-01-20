package com.test.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.test.service.CountCharacterService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterCounterTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    CountCharacterService countCharacterService;
    private String answer;

    @BeforeEach
    void setUp() {
        answer = "[a:5, c:4, b:1]";
    }

    @SneakyThrows
    @Test
    void countCharacter() {
        when(countCharacterService.getCount(any()))
                .thenReturn(answer);

        mockMvc.perform(post("/api/counter")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}