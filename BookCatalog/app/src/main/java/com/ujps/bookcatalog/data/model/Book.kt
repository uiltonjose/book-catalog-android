package com.ujps.bookcatalog.data.model

import com.google.gson.annotations.SerializedName

data class Book(
        @JvmField
        @SerializedName("title")
        val title: String? = null,

        @JvmField
        @SerializedName("category")
        val category: String? = null,

        @JvmField
        @SerializedName("description")
        val description: String? = null,

        @JvmField
        @SerializedName("imageUrl")
        val thumbnail: String? = null
)

