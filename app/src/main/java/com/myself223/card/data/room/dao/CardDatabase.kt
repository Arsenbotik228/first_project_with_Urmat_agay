package com.myself223.card.data.room.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.myself223.card.data.room.converter.Converter
import com.myself223.card.data.room.models.CardModel


@Database(entities = [CardModel::class], version = 3)
@TypeConverters(Converter::class)
abstract class CardDatabase:RoomDatabase() {

    abstract fun getDao(): Dao

}