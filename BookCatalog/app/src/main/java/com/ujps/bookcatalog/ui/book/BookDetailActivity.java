package com.ujps.bookcatalog.ui.book;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ujps.bookcatalog.R;
import com.ujps.bookcatalog.utils.ConstantsUtil;
import com.ujps.bookcatalog.utils.ImageUtil;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Declaring the properties view that will hold the received values
        TextView tvTitle = findViewById(R.id.tvBookTitle);
        TextView tvCategory = findViewById(R.id.tvBookCategory);
        TextView tvDescription = findViewById(R.id.tvBookDescription);
        ImageView imgThumbnail = findViewById(R.id.bookImageThumbnail);

        // Receiving data from previous screen.
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString(ConstantsUtil.TITLE_KEY);
        String category = bundle.getString(ConstantsUtil.CATEGORY_KEY);
        String description = bundle.getString(ConstantsUtil.DESCRIPTION_KEY);
        String thumbnail = bundle.getString(ConstantsUtil.THUMBNAIL_KEY);

        // Set of data
        tvTitle.setText(title);
        tvCategory.setText(category);
        tvDescription.setText(description);
        ImageUtil.fetchImage(this, thumbnail, imgThumbnail);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
