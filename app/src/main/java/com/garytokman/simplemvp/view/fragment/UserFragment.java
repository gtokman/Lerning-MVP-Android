package com.garytokman.simplemvp.view.fragment;
// Gary Tokman
// 11/25/16
// SimpleMVP

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.garytokman.simplemvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class UserFragment extends Fragment {


    @BindView(R.id.first_edit_text)
    EditText mFirstEditText;
    @BindView(R.id.second_edit_text)
    EditText mSecondEditText;


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

    }

    @OnClick(R.id.button)
    public void onClickSaveButton(View view) {
        Timber.i("Click save!");
    }
}
