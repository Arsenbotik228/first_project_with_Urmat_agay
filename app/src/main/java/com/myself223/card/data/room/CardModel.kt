package com.myself223.card.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.io.Serializable
import java.util.Locale.Category

@Entity(tableName = "Cards")
data class CardModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    @TypeConverters(Converter::class)
    var list: List<CategoryModel>
)