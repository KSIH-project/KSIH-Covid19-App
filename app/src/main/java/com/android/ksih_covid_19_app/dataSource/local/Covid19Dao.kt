package com.android.ksih_covid_19_app.dataSource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.ksih_covid_19_app.model.Country
import com.android.ksih_covid_19_app.model.Global
import com.android.ksih_covid_19_app.model.LiveByCountryAndStatusItem


/**
 * Created by SegunFrancis
 */
@Dao
interface Covid19Dao {

    @Query("SELECT * FROM LiveByCountryAndStatusItem")
    fun getLiveByCountryAndStatus(): LiveData<List<LiveByCountryAndStatusItem?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setLiveByCountryAndStatus(responseList: List<LiveByCountryAndStatusItem?>)

    @Query("SELECT * FROM country_table WHERE Country LIKE :searchString")
    fun getSearchAllCountries(searchString: String): LiveData<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setCountryAndNewCasesList(countryList: List<Country>?)

    @Query("SELECT * FROM COUNTRY_TABLE")
    fun getCountryAndNewCasesList():LiveData<List<Country>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setGlobalList(responseList:Global)

    @Query("SELECT * FROM Global")
    fun getGlobalList(): LiveData<Global>

}