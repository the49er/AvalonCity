package com.servlet.test.calc;

import lombok.Data;

@Data
public class CalcResponse {
    private int result;
    private CalcRequest request;

}
