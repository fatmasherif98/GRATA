package com.example.android.grata.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_gratitude_entry")
data class GratitudeEntry(
    @PrimaryKey(autoGenerate = true)
    var entryId: Long = 0L,

    @ColumnInfo(name = "first_entry")
    var firstEntry: String = "",

    @ColumnInfo(name = "second_entry")
    var secondEntry: String = "",

    @ColumnInfo(name = "thrid_entry")
    var thirdEntry: String = "",

    @ColumnInfo(name = "date")
    var date: String = ""

)