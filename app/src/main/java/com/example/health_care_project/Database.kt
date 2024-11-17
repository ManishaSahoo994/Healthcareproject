package com.example.health_care_project

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Database(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        // Create the "users" table
        val qry1 = "CREATE TABLE users(username TEXT, email TEXT, password TEXT)"
        sqLiteDatabase.execSQL(qry1)

        // Create the "cart" table
        val qry2 = "CREATE TABLE cart(username TEXT, product TEXT, price REAL, otype TEXT)"
        sqLiteDatabase.execSQL(qry2)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Drop older tables if they exist and recreate them
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users")
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cart")
        onCreate(sqLiteDatabase)
    }

    // Function to register a new user
    fun register(username: String, email: String, password: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put("username", username)
        cv.put("email", email)
        cv.put("password", password)

        db.insert("users", null, cv)
        db.close()
    }

    // Function to log in a user
    fun login(username: String, password: String): Int {
        var result = 0
        val str = arrayOf(username, password)
        val db = readableDatabase
        val c: Cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", str)

        if (c.moveToFirst()) {
            result = 1  // User found
        }
        c.close()
        db.close()  // Close the database
        return result
    }

    // Function to add an item to the cart
    fun addCart(username: String, product: String, price: Float, otype: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put("username", username)
        cv.put("product", product)
        cv.put("price", price)
        cv.put("otype", otype)

        db.insert("cart", null, cv)
        db.close()
    }

    // Function to check if a specific product is in the cart
    fun checkCart(username: String, product: String): Int {
        var result = 0
        val str = arrayOf(username, product)
        val db = readableDatabase
        val c: Cursor = db.rawQuery("SELECT * FROM cart WHERE username=? AND product=?", str)

        if (c.moveToFirst()) {
            result = 1  // Product found in the cart
        }
        c.close()
        db.close()
        return result
    }

    // Function to remove items from the cart based on username and order type
    fun removeCart(username: String, otype: String) {
        val db = writableDatabase
        val str = arrayOf(username, otype)
        db.delete("cart", "username=? AND otype=?", str)
        db.close()
    }
}
