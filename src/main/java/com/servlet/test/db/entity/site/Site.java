package com.servlet.test.db.entity.site;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@ToString
public class Site {
    private long id;
    private String name;
}
