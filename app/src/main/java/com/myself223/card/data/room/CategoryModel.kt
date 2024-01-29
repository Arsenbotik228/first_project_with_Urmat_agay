package com.myself223.card.data.room

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Category")
data class CategoryModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    @ColumnInfo(name = "title")
    val name:String



) : Serializable
