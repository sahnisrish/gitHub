package com.example.sahni.github;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity extends AppCompatActivity {
    String username;
    TextView name;
    TextView location;
    TextView contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = findViewById(R.id.name);
        location = findViewById(R.id.location);
        contact = findViewById(R.id.contact);

        Intent intent=getIntent();
        username=intent.getExtras().getString(Constant.USERNAME_KEY);
        getSupportActionBar().setTitle(username);

        CollapsingToolbarLayout appBar=findViewById(R.id.toolbar_layout);
        appBar.setCollapsedTitleTextColor(appBar.getResources().getColor(R.color.GitHubBack));
        appBar.setExpandedTitleColor(appBar.getResources().getColor(R.color.colorPrimary));

        FetchUser();
    }

    private void FetchUser() {
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();
        GetUsers getUsers=retrofit.create(GetUsers.class);
        Call<UserDetails> call=getUsers.getUser(username);
        call.enqueue(new Callback<UserDetails>() {
            @Override
            public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                UserDetails user=response.body();
                name.setText(user.name);
                location.setText(user.location);
                contact.setText(user.contact);

            }

            @Override
            public void onFailure(Call<UserDetails> call, Throwable t) {

            }
        });
    }
}
