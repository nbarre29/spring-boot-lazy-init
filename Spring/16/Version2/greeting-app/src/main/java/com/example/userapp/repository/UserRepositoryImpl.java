package com.example.userapp.repository;

import com.example.userapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepositoryImpl() {
        users.add(new User(1L, "Alice", 25));
        users.add(new User(2L, "Bob", 30));
        users.add(new User(3L, "Charlie", 25));
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);   // return users;  is sufficient
    }
}
