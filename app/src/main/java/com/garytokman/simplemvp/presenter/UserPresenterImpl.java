package com.garytokman.simplemvp.presenter;// Gary Tokman

import android.text.TextUtils;

import com.garytokman.simplemvp.model.User;
import com.garytokman.simplemvp.repo.UserRepository;
import com.garytokman.simplemvp.view.fragment.UserView;

import timber.log.Timber;

// 11/25/16
// SimpleMVP
public class UserPresenterImpl implements UserPresenter {

    private UserView mUserView;
    private UserRepository mUserRepository;
    private User mUser;

    public UserPresenterImpl(UserRepository userRepository) {
        mUserRepository = userRepository;
    }

    @Override
    public void loadUserDetails() {
        int userId = mUserView.getUserId();
        mUser = mUserRepository.getUser(userId);

        if (mUser == null) {
            mUserView.showUserNotFoundMessage();
        } else {
            mUserView.displayFirstName(mUser.getFirstName());
            mUserView.displayLastName(mUser.getLastName());
        }
    }

    @Override
    public void setView(UserView view) {
        mUserView = view;
    }

    @Override
    public void saveUser() {
        if (mUser != null) {
            if (TextUtils.isEmpty(mUserView.getFirstName()) || TextUtils.isEmpty(mUserView.getLastName())) {
                mUserView.showUserNameIsRequired();
            } else {
                mUser.setFirstName(mUserView.getFirstName());
                mUser.setLastName(mUserView.getLastName());
                mUserRepository.save(mUser);
                mUserView.showUserSavedMessage();
            }
        }
    }

    @Override
    public void resume() {
        loadUserDetails();
        Timber.i("on resume called");
    }

    @Override
    public void pause() {
        Timber.i("on pause called");

    }
}
