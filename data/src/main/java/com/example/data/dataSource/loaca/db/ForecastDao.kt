package com.example.data.dataSource.loaca.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dataSource.loaca.db.entity.ForecastEntity
import com.example.data.dataSource.loaca.db.entity.ForecastLastFiveDaysEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ForecastDao {

    @Query("SELECT * FROM forecast")
     fun getAll(): Flow<ForecastEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(forecast: ForecastEntity)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

    @Query("DELETE FROM forecast")
    fun deleteAll()



    ////////// Query for last five days //////////////


    @Query("SELECT * FROM forecastlastfivedays")
    fun getLastFiveDaysData(): Flow<List<ForecastLastFiveDaysEntity>?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLastFiveDaysData(forecast: List<ForecastLastFiveDaysEntity>)

//    @Query("UPDATE character SET base64 = :image WHERE id = :id")
//    fun updateImage(id: Int, image: String)

    @Query("DELETE FROM forecastlastfivedays")
    fun deleteLastFiveDaysData()
}