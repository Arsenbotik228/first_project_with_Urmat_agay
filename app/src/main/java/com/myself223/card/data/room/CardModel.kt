package com.myself223.card.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Locale.Category

@Entity(tableName = "Cards")
data class CardModel (
    @PrimaryKey(autoGenerate = true)
    val age :Int,
    val id : Int,
    val name :String,
    val list : List<CategoryModel>

    )