package com.garytokman.simplemvp;
// Gary Tokman
// 11/25/16
// SimpleMVP

import com.garytokman.simplemvp.repo.InMemoryUserRepoImp;
import com.garytokman.simplemvp.repo.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides @Singleton
    public UserRepository provideUserRepository() {
        return new InMemoryUserRepoImp();
    }
}
