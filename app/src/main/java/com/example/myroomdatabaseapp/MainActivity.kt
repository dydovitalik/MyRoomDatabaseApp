package com.example.myroomdatabaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.room.Room
import com.example.myroomdatabaseapp.db.AppDatabase
import com.example.myroomdatabaseapp.db.RestaurantMenu

class MainActivity : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDatabase()
    }

    override fun onResume(){
        super.onResume()
        testDatabase()
    }

    private fun log(message: String) {
        Log.d("TEST_DB", message)
    }

    private fun testDatabase() {
        //  CREATE
        val restaurantMenu1 = RestaurantMenu(1,"McMuffin Meal",6.99f,200,1)
        val restaurantMenu2 = RestaurantMenu(2,"Spaghettios Pizza",13.99f,150,1)
        val restaurantMenu3 = RestaurantMenu(3,"McNuggets",3.99f, 100, 1)

        val restaurantMenus = mutableListOf<RestaurantMenu>()
        restaurantMenus.add(restaurantMenu1)
        restaurantMenus.add(restaurantMenu2)
        restaurantMenus.add(restaurantMenu3)

        db.restaurantMenuDao().insert(restaurantMenu1)
        log("insert $restaurantMenu1")
        db.restaurantMenuDao().insert(restaurantMenu2)
        log("insert $restaurantMenu2")
        db.restaurantMenuDao().insert(restaurantMenu3)
        log("insert $restaurantMenu3")

        db.restaurantMenuDao().insert(restaurantMenus)
        log("insert $restaurantMenus")

        //UPDATE
        val modifyUser = RestaurantMenu(2,"Spaghettios Pizza",13.99f,150,1)
        db.restaurantMenuDao().update(modifyUser)
        log("update $restaurantMenu2")

        //DELETE
        db.restaurantMenuDao().delete(restaurantMenu3)
        log("delete $restaurantMenu3")


        //READ
        val readrestaurantMenus = db.restaurantMenuDao().getAll()
        for (restaurantMenu in readrestaurantMenus){
            log("read $restaurantMenu")
        }
    }


    private fun initDatabase() {
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "test-database"
        ).allowMainThreadQueries().build()

    }
}