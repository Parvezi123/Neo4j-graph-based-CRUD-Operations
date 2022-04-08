package com.neo4j.graph.repository;

import com.neo4j.graph.model.Rating;
import com.neo4j.graph.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserGraphRepository extends Neo4jRepository<User,Long> {

    User save(User user);
    User findUserById(Long id);
    List<Rating> findAllByRating();

    @Query("MATCH (user:USER) where user.id=$id DETACH DELETE user")
    String deleteUserGraphById(@Param("id") Long id);

    @Query("MATCH (n) DETACH DELETE n")
    void deleteAll();

    List<User> findAll();


}
