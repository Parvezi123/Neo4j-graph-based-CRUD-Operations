package com.neo4j.graph.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
@Data
public class Movie {
    @Id
    private Long id;
    private String title;
    private String director;

}
