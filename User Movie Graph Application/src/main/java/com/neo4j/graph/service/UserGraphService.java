package com.neo4j.graph.service;

import com.neo4j.graph.model.User;
import com.neo4j.graph.repository.UserGraphRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserGraphService {

    private final UserGraphRepository userGraphRepository;


    public UserGraphService(UserGraphRepository userGraphRepository) {
        this.userGraphRepository = userGraphRepository;
    }

    public User createUserGraph(User user) {
        return userGraphRepository.save(user);
    }

    public List<User> getAllUserRatings() {
        return userGraphRepository.findAll();
    }


    public User updateUserGraph(User user) {
        User updatedUser = null;
        if(userGraphRepository.findUserById(user.getId()) != null) {
            updatedUser = userGraphRepository.save(user);
        }
        return updatedUser;
    }

    public User findUserEntry(long userId) {
            User user =  userGraphRepository.findUserById(userId);
            if ( user == null) {
                return new User(0L,"User Details Not Found for the requested ID Try Again",0,null);
            }
        return user;
    }


    public String deleteUserGraphByID(Long userId) {

        if(findUserEntry(userId) != null) {
            return userGraphRepository.deleteUserGraphById(userId);
        }
        return "User Id Not found !!! Try Again";
    }

    public String deleteAllUserGraph() {

        userGraphRepository.deleteAll();
        return "Deleted All entries from the graph";
    }
}

