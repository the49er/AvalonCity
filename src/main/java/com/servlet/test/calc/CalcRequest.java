package com.servlet.test.calc;

import lombok.Data;

@Data
public class CalcRequest {
    private String operations;
    private int param1;
    private int param2;

}
