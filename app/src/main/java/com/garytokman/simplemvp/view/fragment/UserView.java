package com.garytokman.simplemvp.view.fragment;
// Gary Tokman
// 11/25/16
// SimpleMVP

public interface UserView {
    int getUserId();

    void displayFirstName(String name);

    void displayLastName(String name);

    void showUserNotFoundMessage();

    void showUserSavedMessage();

    String getFirstName();

    String getLastName();

    void showUserNameIsRequired();
}
