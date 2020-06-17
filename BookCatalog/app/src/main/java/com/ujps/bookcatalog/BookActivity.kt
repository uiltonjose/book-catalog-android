package com.ujps.bookcatalog

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.ujps.bookcatalog.data.model.Book
import com.ujps.bookcatalog.data.network.BookResponse
import com.ujps.bookcatalog.data.repository.BookRepository
import com.ujps.bookcatalog.ui.book.BookAdapter
import kotlinx.android.synthetic.main.activity_main.recyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookActivity : AppCompatActivity(){

    private var adapter: BookAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }

    override fun onResume() {
        super.onResume()
        fetchBookList()
    }

    private fun fetchBookList() {
        BookRepository.getBookList(object : Callback<BookResponse> {
            override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                Log.e("MainActivity", t.message)
            }

            override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                if (response.isSuccessful) {
                    response.body()?.also {
                        populateBookList(it.bookList)
                    }
                }
            }
        })
    }

    private fun populateBookList(books: List<Book>) {
        adapter = BookAdapter(this, books)
        recyclerView.adapter = adapter
    }
}