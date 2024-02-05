package com.myself223.card.data.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ProfileData")
data class ProfileModels (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "Name")
    val name: String,
    @ColumnInfo(name = "Famile")
    val Famile: String,
    @ColumnInfo(name = "Email")
    val email: String,


)
