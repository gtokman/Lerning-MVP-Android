package com.garytokman.simplemvp.repo;
// Gary Tokman
// 11/25/16
// SimpleMVP

import com.garytokman.simplemvp.model.User;

public interface UserRepository {

    User getUser(int id);

    void save(User user);
}
