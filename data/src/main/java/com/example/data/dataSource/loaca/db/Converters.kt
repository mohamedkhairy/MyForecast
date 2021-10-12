package com.example.data.dataSource.loaca.db

import androidx.room.TypeConverter
import com.example.data.dataSource.loaca.db.entity.WeatherEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class Converters {

  @TypeConverter
  fun stringToListServer(data: String?): List<WeatherEntity?>? {
    if (data == null) {
      return Collections.emptyList()
    }
    val listType: Type = object :
      TypeToken<List<WeatherEntity>?>() {}.type
    return Gson().fromJson<List<WeatherEntity>>(data, listType)
  }

  @TypeConverter
  fun listServerToString(someObjects: List<WeatherEntity>?): String? {
    return Gson().toJson(someObjects)
  }

}