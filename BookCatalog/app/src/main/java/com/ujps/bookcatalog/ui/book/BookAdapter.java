package com.ujps.bookcatalog.ui.book;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ujps.bookcatalog.R;
import com.ujps.bookcatalog.data.model.Book;
import com.ujps.bookcatalog.utils.ConstantsUtil;
import com.ujps.bookcatalog.utils.ImageUtil;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private Context context;
    private List<Book> bookList;

    public BookAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_book_view, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        final Book book = bookList.get(position);
        holder.tvBookTitle.setText(book.title);

        // It will fetch the image in Ansyc mode
        ImageUtil.fetchImage(context, book.thumbnail, holder.ivBookImage);

        holder.cvCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BookDetailActivity.class);

                // Passing data to the BookDetailActivity
                intent.putExtra(ConstantsUtil.TITLE_KEY, book.title);
                intent.putExtra(ConstantsUtil.CATEGORY_KEY, book.category);
                intent.putExtra(ConstantsUtil.DESCRIPTION_KEY, book.description);
                intent.putExtra(ConstantsUtil.THUMBNAIL_KEY, book.thumbnail);

                // Call next screen
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        TextView tvBookTitle;
        ImageView ivBookImage;
        CardView cvCard;

        public BookViewHolder(View itemView) {
            super(itemView);

            tvBookTitle = itemView.findViewById(R.id.bookTitle);
            ivBookImage = itemView.findViewById(R.id.bookImage);
            cvCard = itemView.findViewById(R.id.cardViewItem);
        }
    }
}
