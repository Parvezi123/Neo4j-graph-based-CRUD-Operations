package com.neo4j.graph.controller;

import com.neo4j.graph.model.User;
import com.neo4j.graph.service.UserGraphService;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
@RequestMapping( "/user")
public class UserGraphController {


    private UserGraphService userGraphService;

    public UserGraphController(UserGraphService userGraphService) {
        this.userGraphService = userGraphService;
    }

    @Timed(value = "user.create",description = "Create the usernode in the graph",histogram = true)
    @RequestMapping(value = "/graph/create",method = RequestMethod.POST)
    public User postUser(@RequestBody User user) {
        return   userGraphService.createUserGraph(user);
    }


    @Timed(value = "user.update",description = "update the user node in the graph",histogram = true)
    @RequestMapping(value = "/graph/update",method = RequestMethod.PUT)
    public User updateUserGraph(@RequestBody User user) {
        return userGraphService.updateUserGraph(user);
    }


    @Timed(value = "user.all",description = "Retrieve all user nodes in the graph",histogram = true)
    @GetMapping("/graph/all")
    public List<User> retrieveAllUserRatings() {
        return userGraphService.getAllUserRatings();
    }


    @Timed(value="user.id",description = "Retrieve user node in the graph",histogram = true)
    @GetMapping("/graph/all/{id}")
    public User retrieveUserById(@PathVariable String id) {
        Long userId = Long.valueOf(id);
        return userGraphService.findUserEntry(userId);
    }



    @Timed(value = "user.delete",description = "delete usernode by id",histogram = true)
    @RequestMapping(value = "/graph/delete/{id}",method = RequestMethod.DELETE)
    public String deleteUserNodeById(@PathVariable String id) {
        long userId = Long.parseLong(id);
        return userGraphService.deleteUserGraphByID(userId);
    }


    @Timed(value = "user.deleteall",description = "delete all nodes in the graph",histogram = true)
    @RequestMapping(value = "/graph/delete/all",method = RequestMethod.DELETE)
    public String deleteAllUserGraphs() {
        return userGraphService.deleteAllUserGraph();
    }
}
