package com.example.apkrestaurant.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Menu::class], version = 1)
abstract class MenuDatabase : RoomDatabase(){
    abstract fun menuDao():MenuDao

    companion object{
        private var INSTANCE: MenuDatabase? = null

        fun getIntance(context: Context): MenuDatabase{
            synchronized(this){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,MenuDatabase::class.java,"menu-db"
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}