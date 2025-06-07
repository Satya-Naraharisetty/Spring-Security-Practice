package com.springsec.springsecdemo.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private String name;
    private String tech;
}
