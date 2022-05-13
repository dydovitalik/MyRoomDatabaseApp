package com.example.myroomdatabaseapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

//Використовується тільки одна єдина таблиця типу Entity під класом який називається RestaurantMenu
// Версія - треба повідомляти що змінілася структура бази данних
@Database(entities = [RestaurantMenu::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun restaurantMenuDao(): RestaurantMenuDao
}