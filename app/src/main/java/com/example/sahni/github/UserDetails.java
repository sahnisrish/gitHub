package com.example.sahni.github;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sahni on 17/3/18.
 */

public class UserDetails {
    @SerializedName("login")
    String username;
    long id;
    int public_repos;
    String name;
    String location;
    @SerializedName("avatar_url")
    String avatar;
    @SerializedName("email")
    String contact;
    @SerializedName("url")
    String link;
    String repos_url;
    ArrayList<Repos> repos;

    public class Repos{
        long id;
        String name;
    }

}
