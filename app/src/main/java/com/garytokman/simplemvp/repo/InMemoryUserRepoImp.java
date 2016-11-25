package com.garytokman.simplemvp.repo;
// Gary Tokman
// 11/25/16
// SimpleMVP

import com.garytokman.simplemvp.model.User;

public class InMemoryUserRepoImp implements UserRepository {

    private User user;

    @Override
    public User getUser(int id) {

        // Normally go to DB and fetch the user with the id.
        if (user == null) {
            user = new User();
            user.setId(id);
            user.setFirstName("Gary");
            user.setLastName("Tokman");
        }

        return user;
    }

    @Override
    public void save(User user) {
        if (this.user == null) {
            this.user = getUser(0);
        }

        this.user.setId(user.getId());
        this.user.setFirstName(user.getFirstName());
        this.user.setLastName(user.getLastName());
    }
}
