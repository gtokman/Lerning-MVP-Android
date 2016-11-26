package com.garytokman.simplemvp;
// Gary Tokman
// 11/25/16
// SimpleMVP

import com.garytokman.simplemvp.view.fragment.UserFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(UserFragment target);
}
