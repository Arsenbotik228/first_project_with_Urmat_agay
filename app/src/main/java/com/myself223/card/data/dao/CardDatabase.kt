package com.myself223.card.data.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [CardDatabase::class], version = 2)
abstract class CardDatabase:RoomDatabase() {



    abstract fun getDao(): Dao
    companion object{
        @Volatile
        private var instance:CardDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also {
                instance = it
            }
        }





        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                CardDatabase::class.java,
                "MyDatabase.db"
            ).allowMainThreadQueries().build()



    }
}