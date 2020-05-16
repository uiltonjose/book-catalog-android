package com.ujps.bookcatalog.data.model;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("title")
    public String title;

    @SerializedName("category")
    public String category;

    @SerializedName("description")
    public String description;

    @SerializedName("imageUrl")
    public String thumbnail;
}
