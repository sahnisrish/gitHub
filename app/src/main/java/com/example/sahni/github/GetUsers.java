package com.example.sahni.github;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sahni on 17/3/18.
 */

public interface GetUsers {
    @GET("users/{uname}")
    Call<UserDetails> getUser(@Path("uname") String username);

}
