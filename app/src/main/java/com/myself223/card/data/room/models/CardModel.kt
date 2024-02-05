package com.myself223.card.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.myself223.card.data.room.converter.Converter

@Entity(tableName = "Cards")
data class CardModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    @TypeConverters(Converter::class)
    var list: List<CategoryModel>
)