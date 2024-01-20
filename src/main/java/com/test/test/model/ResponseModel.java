package com.test.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private Character character;
    private Integer count;


    @Override
    public String toString() {
        return
                character +
                        ":" + count;
    }
}
