package com.abhidev.repositories;

import com.abhidev.apiservices.ApiClient;
import com.abhidev.apiservices.ApiEndpoint;
import com.abhidev.apiservices.responses.GenericResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Rishabh on 3/6/2018.
 */

public class FirebaseRepository {
    ApiEndpoint apiService = ApiClient.getClient().create(ApiEndpoint.class);

    public void sendRegistrationIdToServer(String token, Callback callback){
        Call<GenericResponse> call = apiService.sendTokenToServer(token);
        call.enqueue(callback);

    }

}
