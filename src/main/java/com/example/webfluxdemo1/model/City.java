package com.example.webfluxdemo1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class City {

    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;
}
