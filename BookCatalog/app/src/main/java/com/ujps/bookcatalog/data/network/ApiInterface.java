package com.ujps.bookcatalog.data.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/books")
    Call<BookResponse> getBookList();
}
