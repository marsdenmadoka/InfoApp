package com.example.newsapp.data.manger

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.example.newsapp.domain.manger.LocalUserManger
import com.example.newsapp.util.Constants
import com.example.newsapp.util.Constants.APP_ENTRY
import com.example.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//implementing a jetpack datastore preferences - a jetpack library that allows us to save keys values locally
class LocalUserMangerImpl (
    private val context: Context
):LocalUserManger {
    override suspend fun saveAppEntry() {
        context.dataStore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }
//reading our keys
    override fun readAppEntry(): Flow<Boolean> {
       return context.dataStore.data.map {preferences ->
           preferences[PreferencesKeys.APP_ENTRY]?:false //if no values return false
       }
    }
}
//we want to have instance from the datastore//extension function ||access objet dataStore via context
private val Context.dataStore:DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

//to be able to save key values in our datastore preference
private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)

}


//nstance required to make a call to the member, or an outer class instance for an inner class constructor.