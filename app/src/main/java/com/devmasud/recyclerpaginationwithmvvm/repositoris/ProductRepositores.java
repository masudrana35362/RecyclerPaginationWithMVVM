package com.devmasud.recyclerpaginationwithmvvm.repositoris;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveResponse;
import com.devmasud.recyclerpaginationwithmvvm.network.ApiClient;
import com.devmasud.recyclerpaginationwithmvvm.network.ApiServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepositores {
    ApiServices apiServices;

    public ProductRepositores() {
        apiServices =ApiClient.getRetrofit().create(ApiServices.class);

    }

    public LiveData<BigSaveResponse> getProducts(int page){
        MutableLiveData<BigSaveResponse> data=new MutableLiveData<>();

        apiServices.BigSaveProduct(10,page).enqueue(new Callback<BigSaveResponse>() {
            @Override
            public void onResponse(@NonNull Call<BigSaveResponse> call, @NonNull Response<BigSaveResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<BigSaveResponse> call,@NonNull Throwable t) {

            }
        });
        return data;
    }
}
