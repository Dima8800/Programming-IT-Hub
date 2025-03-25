package it_hub.task.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String name;

    private String surname;

    private String phone;

    private List<Car> cars;
}
