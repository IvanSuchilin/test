package com.test.test.validation;

import com.test.test.exception.RequestValidationException;
import com.test.test.model.RequestModel;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class Validation {
    LocalDateTime time = LocalDateTime.now();

    public void validateInputString(RequestModel requestModel) {
        if (requestModel == null || StringUtils.isBlank(requestModel.getContent())) {
            throw new RequestValidationException(
                    "Ошибка в теле запроса",
                    "Строка пуста или тело null",
                    time
            );
        }
    }

}
