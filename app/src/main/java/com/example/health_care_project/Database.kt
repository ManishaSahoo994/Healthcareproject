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
        // Create the table with username, email, and password fields
        val qry1 = "CREATE TABLE users(username TEXT, email TEXT, password TEXT)"
        sqLiteDatabase.execSQL(qry1)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Typically, this method should alter the schema of the database,
        // not insert data. You can leave it empty or modify the schema if needed.
    }

    // Function to register a new user by inserting their data into the database
    fun register(username: String, email: String, password: String) {
        val db = writableDatabase
        val cv = ContentValues()

        cv.put("username", username)
        cv.put("email", email)
        cv.put("password", password)

        db.insert("users", null, cv)
        db.close()
    }

    // Function to log in the user by checking if their username and password match
    fun login(username: String, password: String): Int {
        var result = 0
        val str = arrayOf(username, password)
        val db = readableDatabase
        val c: Cursor = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", str)

        if (c.moveToFirst()) {
            result = 1  // User found
        }
        c.close()  // Always close the cursor after use
        return result
    }
}
