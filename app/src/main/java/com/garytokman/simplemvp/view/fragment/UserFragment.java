package com.garytokman.simplemvp.view.fragment;
// Gary Tokman
// 11/25/16
// SimpleMVP

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.garytokman.simplemvp.R;
import com.garytokman.simplemvp.SimpleApp;
import com.garytokman.simplemvp.presenter.UserPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class UserFragment extends Fragment implements UserView {


    @Inject UserPresenter mUserPresenter;

    public static final String USER_ID = "user_id";

    @BindView(R.id.first_edit_text)
    EditText mFirstEditText;
    @BindView(R.id.second_edit_text)
    EditText mSecondEditText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SimpleApp) getActivity().getApplication()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_layout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUserPresenter.setView(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        mUserPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mUserPresenter.pause();
    }

    @OnClick(R.id.button)
    public void onClickSaveButton(View view) {
        Timber.i("Click save!");
        mUserPresenter.saveUser();
    }

    @Override
    public int getUserId() {
        return getArguments() == null ? 0 : getArguments().getInt(USER_ID, 0);
    }

    @Override
    public void displayFirstName(String name) {
        mFirstEditText.setText(name);
    }

    @Override
    public void displayLastName(String name) {
        mSecondEditText.setText(name);
    }

    @Override
    public void showUserNotFoundMessage() {
        Snackbar.make(getView(), "User not found", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showUserSavedMessage() {
        Snackbar.make(getView(), "User has been saved", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public String getFirstName() {
        return mFirstEditText.getText().toString();
    }

    @Override
    public String getLastName() {
        return mSecondEditText.getText().toString();
    }

    @Override
    public void showUserNameIsRequired() {
        Toast.makeText(getActivity(), "User name is required", Toast.LENGTH_SHORT).show();
    }
}
