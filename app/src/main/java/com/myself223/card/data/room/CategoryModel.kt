package com.myself223.card.data.room

import android.media.Image
import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Category")
data class CategoryModel(
    @PrimaryKey(autoGenerate = true)
    val name:String,
    val image: Image




) : Serializable
