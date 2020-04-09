package com.android.ksih_covid_19_app.dataSource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.model.DayOneTotalResponseItem
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem
import com.android.ksih_covid_19_app.model.Summary

/**
 * Created by SegunFrancis
 */

@Database(
    exportSchema = false,
    version = 1,
    entities = [
        LiveByCountryAndStatusItem::class,
        DayOneTotalResponseItem::class
    ]
)
abstract class Covid19RoomDatabase : RoomDatabase() {
    abstract fun covid19Dao(): Covid19Dao

    companion object {
        @Volatile
        private var INSTANCE: Covid19RoomDatabase? = null

        fun getDatabase(context: Context): Covid19RoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Covid19RoomDatabase::class.java,
                    "covid_19_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}