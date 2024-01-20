package com.test.test.controller;

import com.test.test.model.RequestModel;
import com.test.test.service.CountCharacterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CharacterCounter {

    private final CountCharacterService countCharacterService;

    @PostMapping("/api/counter")
    public ResponseEntity<Object> countCharacter(@RequestBody(required = false) RequestModel requestModel) {
        log.info("POST-запрос /api/counter");
        return new ResponseEntity<>(countCharacterService.getCount(requestModel), HttpStatus.OK);
    }
}
