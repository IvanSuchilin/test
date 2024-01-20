package com.test.test.service;

import com.test.test.model.RequestModel;
import com.test.test.model.ResponseModel;
import com.test.test.validation.Validation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountCharacterService {
    private final Validation validation;

    public String getCount(RequestModel requestModel) {
        validation.validateInputString(requestModel);
        log.info("Запрос подсчета частоты встречи сиволов в строке " + requestModel.getContent());
        String prepareString = requestModel.getContent().trim().replaceAll(" ", "");
        return countChar(prepareString).toString();
    }

    private List<ResponseModel> countChar(String string) {
        Map<Character, Integer> characterMap = new TreeMap<>();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }
        return characterMap.entrySet()
                .stream()
                .map((e) -> new ResponseModel(e.getKey(), e.getValue()))
                .sorted((e1, e2) -> Integer.compare(e2.getCount(), e1.getCount())).toList();
    }
}
