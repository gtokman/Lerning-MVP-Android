package com.garytokman.simplemvp.view.fragment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.garytokman.simplemvp.R;
import com.garytokman.simplemvp.view.fragment.UserFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new UserFragment(), "User_Fragment")
                .commit();
    }

    @OnClick(R.id.floatingActionButton)
    public void onClickFab(View view) {
        Timber.i("Click fab!");
    }
}
