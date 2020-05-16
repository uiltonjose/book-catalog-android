package com.ujps.bookcatalog.data.repository;

import com.ujps.bookcatalog.data.network.APIController;
import com.ujps.bookcatalog.data.network.BookResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class BookRepository extends APIController {

    public static void getBookList(Callback<BookResponse> callback) {
        Call<BookResponse> call = getRetrofit().getBookList();
        call.enqueue(callback);
    }
}
