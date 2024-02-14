package com.example.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.newsapp.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    // We can only save primitive data types in room and not objects therefore we have to convert our source using type converters
    @TypeConverter
    fun sourceToString(source:Source):String {

        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source:String):Source{
        return source.split(',').let { sourceArray ->
            Source(id=sourceArray[0], name = sourceArray[1]) //index 0 is id and index 1 is name

        }
    }

}
