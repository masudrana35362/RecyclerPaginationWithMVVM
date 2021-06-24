package com.devmasud.recyclerpaginationwithmvvm.network;
import com.devmasud.recyclerpaginationwithmvvm.model.BigSaveResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {
    @GET("product_list_random/{limit}?")
    Call<BigSaveResponse> BigSaveProduct(
            @Path("limit") int limit,
            @Query("page") int page);

}
