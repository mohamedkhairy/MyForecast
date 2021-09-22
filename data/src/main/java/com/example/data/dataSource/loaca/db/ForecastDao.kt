package com.example.data.dataSource.loaca.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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

}