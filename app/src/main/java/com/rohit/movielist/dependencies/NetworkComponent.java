package com.rohit.movielist.dependencies;

import com.rohit.movielist.datasource.repository.DataSource;

import dagger.Component;

@Component(modules = ClientModule.class)
public interface NetworkComponent {
    void inject(DataSource dataSource);
}
