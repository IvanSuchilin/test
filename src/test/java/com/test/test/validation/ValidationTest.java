package com.test.test.validation;

import com.test.test.exception.RequestValidationException;
import com.test.test.model.RequestModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        validation= new Validation();
    }

    @Test
    void validateInputStringIsNull() {
        RequestValidationException thrown = Assertions.assertThrows(RequestValidationException.class,
                () -> validation.validateInputString(new RequestModel()));
        Assertions.assertEquals("Ошибка в теле запроса", thrown.getMessage());
    }

    @Test
    void validateInputRequestNull() {
        RequestValidationException thrown = Assertions.assertThrows(RequestValidationException.class,
                () -> validation.validateInputString(null));
        Assertions.assertEquals("Ошибка в теле запроса", thrown.getMessage());
    }

    @Test
    void validateInputStringIsEmpty() {
        RequestValidationException thrown = Assertions.assertThrows(RequestValidationException.class,
                () -> validation.validateInputString(new RequestModel("")));
        Assertions.assertEquals("Ошибка в теле запроса", thrown.getMessage());
    }
}