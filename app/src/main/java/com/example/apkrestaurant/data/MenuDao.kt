package com.example.apkrestaurant.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuDao {
    @Insert
    suspend fun tambahMenu(menu: Menu)

    @Query("SELECT * FROM menu")
    suspend fun getMenuList():List<Menu>
}