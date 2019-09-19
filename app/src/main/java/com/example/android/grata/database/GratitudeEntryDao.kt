package com.example.android.grata.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface GratitudeEntryDao {

    @Insert
    fun insert( entry: GratitudeEntry)

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM daily_gratitude_entry")
    fun clear()


    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM daily_gratitude_entry ORDER BY entryId DESC")
    fun getAllEntries(): LiveData<List<GratitudeEntry>>

}