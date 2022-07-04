package com.navin.navarch.base

import android.content.Context
import android.content.SharedPreferences
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PrivateSharedPrefManager @Inject constructor(
    private val context: Context
) {
    private var privateSharedPreferences: SharedPreferences? = null
    private val SHARED_PREFERENCES_KEY = "com.navin.navarch"


    init {
        privateSharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCES_KEY,
            Context.MODE_PRIVATE
        )
    }

    companion object : SingletonHolder<PrivateSharedPrefManager, Context>(::PrivateSharedPrefManager)


  /*  fun getInstance(context: Context): PrivateSharedPreferencesManager? {
        synchronized(PrivateSharedPreferencesManager::class.java) {
            if (instance == null) {
                instance = PrivateSharedPreferencesManager(context)
            }
            return instance
        }
    }*/

    fun storeStringInSharedPreferences(
        key: String?,
        content: String?
    ) {
        val editor = privateSharedPreferences!!.edit()
        editor.putString(key, content)
        editor.apply()
    }

    fun getStringFromSharedPreferences(key: String?): String? {
        return privateSharedPreferences?.getString(key, "")
    }

    fun storeIntInSharedPreferences(
        key: String?,
        content: Int?
    ) {
        val editor = privateSharedPreferences!!.edit()
        editor.putInt(key, content!!)
        editor.apply()
    }

    fun getIntFromSharedPreferences(key: String?): Int? {
        return privateSharedPreferences?.getInt(key,-1 )
    }

    fun storeStringSetInSharedPreferences(
        key: String?,
        content: HashSet<String?>?
    ) {
        val editor = privateSharedPreferences!!.edit()
        editor.putStringSet(key, content)
        editor.apply()
    }

    fun getStringSetFromSharedPreferences(key: String?): HashSet<String>? {
        return privateSharedPreferences!!.getStringSet(
            key,
            HashSet()
        ) as HashSet<String>?
    }

    fun clearCache() {
        val editor = privateSharedPreferences!!.edit()
        editor.clear()
        editor.apply()
    }

    fun clearFromSharedPref(key : String?){
      privateSharedPreferences!!.edit().remove(key).apply()
    }
}