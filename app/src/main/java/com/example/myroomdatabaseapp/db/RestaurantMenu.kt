package com.example.myroomdatabaseapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurant_menu") //  Всі поля, які тут є використовуються, щоб створити таблицю
data class RestaurantMenu (
    @PrimaryKey (autoGenerate = true)
    val category: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "price")
    val price: Float,

    @ColumnInfo(name = "weight")
    val weight: Int,

    @ColumnInfo(name = "amount")
    val amount: Int

) {
    // Конвертація об'єкту в рядок
    override fun toString(): String {
        return "RestaurantMenu(category=$category, name='$name', price='$price', weight='$weight', amount='$amount')"
        // Оскільки в нас не має передбачено UI-ки краще ці всі дані виводити в Logcat
    }
}