package com.garytokman.simplemvp.presenter;
// Gary Tokman
// 11/25/16
// SimpleMVP

import com.garytokman.simplemvp.view.fragment.UserView;

public interface UserPresenter extends LifecyclePresenter {

    void loadUserDetails();

    void setView(UserView view);

    void saveUser();

}
