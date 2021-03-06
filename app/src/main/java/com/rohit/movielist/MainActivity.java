package com.rohit.movielist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rohit.movielist.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, HomeFragment.newInstance(this)).commit();

    }
}
