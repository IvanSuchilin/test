package com.test.test.service;

import com.test.test.model.RequestModel;
import com.test.test.validation.Validation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CountCharacterServiceTest {
    private CountCharacterService countCharacterService;

    @BeforeEach
    void setUp() {
        Validation validation = new Validation();
        countCharacterService = new CountCharacterService(validation);
    }

    @Test
    void getCountTestString() {
        RequestModel requestModel = new RequestModel("aaaaabcccc");
        assertEquals(countCharacterService.getCount(requestModel), "[a:5, c:4, b:1]");
    }

    @Test
    void getCountTestStringWithSpace() {
        RequestModel requestModel = new RequestModel("aaaaab cccc");
        assertEquals(countCharacterService.getCount(requestModel), "[a:5, c:4, b:1]");
    }
    @Test
    void getCountTestStringWithNumbersAndOther() {
        RequestModel requestModel = new RequestModel(";aaa bc  ccc2333;332*2%222323 hhцццццц@@ц22ц3цццц***;;;;%%%%c%%%%%@@@@@");
        assertEquals(countCharacterService.getCount(requestModel), "[ц:12, %:10, 2:9, 3:8, @:7, ;:6, c:5, *:4, a:3, h:2, b:1]");
    }
}