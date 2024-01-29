package com.myself223.card.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.myself223.card.data.room.CardModel
import com.myself223.card.data.room.CategoryModel

@Dao
interface Dao {
    @Query("SELECT * FROM category")
    fun getAllCategory():List<CategoryModel>
    @Query("SELECT * FROM cards")
    fun getAllCard(): List<CardModel>
    @Insert
    fun insertCard(model: CardModel)
    @Insert
    fun insertCategory(model: CategoryModel)


}