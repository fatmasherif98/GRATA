package com.example.android.grata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [GratitudeEntry::class],version = 1, exportSchema = false)
abstract class GratitudeDatabase :RoomDatabase() {

    abstract val gratitudeDatabaseDao : GratitudeEntryDao

    companion object{

    @Volatile
    private var INSTANCE : GratitudeDatabase? = null

        fun getInstance(context: Context): GratitudeDatabase{

            synchronized(this){
                var instance = INSTANCE

                if( instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        GratitudeDatabase::class.java,
                        "gratitude_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}