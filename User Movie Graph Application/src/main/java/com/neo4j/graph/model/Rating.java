package com.neo4j.graph.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Data
public class Rating {


    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @TargetNode
    private Movie movie;
    private Integer ratingScore;
    private String movieRating;


}
