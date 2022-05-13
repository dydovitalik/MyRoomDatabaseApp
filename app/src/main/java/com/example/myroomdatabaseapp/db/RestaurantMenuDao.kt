package com.example.myroomdatabaseapp.db

import androidx.room.*

@Dao // Тут описані всі запити
interface RestaurantMenuDao {
    @Query("SELECT * FROM restaurant_menu")
    fun getAll(): List<RestaurantMenu>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(restaurantMenu: RestaurantMenu)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(RestaurantMenus : List<RestaurantMenu>)

    @Update
    fun update(restaurantMenu: RestaurantMenu)

    @Delete
    fun delete(restaurantMenu: RestaurantMenu)
}