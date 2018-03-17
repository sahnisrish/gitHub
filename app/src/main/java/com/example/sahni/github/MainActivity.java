package com.example.sahni.github;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton search;
    EditText searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GitHub");
        search=findViewById(R.id.search);
        searchBar=findViewById(R.id.search_bar);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username;
                username=searchBar.getText().toString();
                if(!username.equals("")) {
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(Constant.USERNAME_KEY, username);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this,"Empty Fields Not allowed",Toast.LENGTH_SHORT).show();
            }
        });
        CollapsingToolbarLayout appBar=findViewById(R.id.toolbar_layout);
        //appBar.setCollapsedTitleTextColor(appBar.getResources().getColor(R.color.GitHubBack));
        appBar.setExpandedTitleColor(appBar.getResources().getColor(R.color.colorPrimary));
    }
}
