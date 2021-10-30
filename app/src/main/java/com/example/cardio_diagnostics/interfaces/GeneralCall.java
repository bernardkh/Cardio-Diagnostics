package com.example.cardio_diagnostics.interfaces;


import com.example.cardio_diagnostics.beans.UserClass;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bkhadra on 8/10/2021.
 */

public interface GeneralCall {

    @GET(" ")
    Call<List<UserClass>> getTodoList();
}
