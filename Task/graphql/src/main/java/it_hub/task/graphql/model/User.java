package it_hub.task.graphql.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Long id;

    private String name;

    private String surname;

    private String phone;

    private List<Car> cars;
}
