package ithub.task.graph.routes.graph.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edge {
    coordinates start;
    coordinates end;
    int weight;
}
