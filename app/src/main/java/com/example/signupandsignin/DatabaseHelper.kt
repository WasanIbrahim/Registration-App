package com.example.signupandsignin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, "details.db", null,2) {
   private val sqLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table details(phone text PRIMARY KEY , Name text, Location text, Password text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS details")
        onCreate(db)
    }

    //Add to database
    fun saveData(user: Details ){
        val contentValues = ContentValues()
        contentValues.put("Phone", user.phone)
        contentValues.put("Name", user.name)
        contentValues.put("Location", user.location)
        contentValues.put("Password", user.password)
        sqLiteDatabase.insert("details",null, contentValues)
    }



    //passing data
    fun getData(phone: String): Details? {

        var user  = Details("","","","")
        val cursor: Cursor = sqLiteDatabase.rawQuery("SELECT * FROM details WHERE Phone LIKE '$phone' ",null)


        if(cursor.count < 1){
            println("No data found")
        }else{

            while (cursor.moveToNext()){
                //Read data

                val phone = cursor.getString(0)
                val name = cursor.getString(1)
                val location = cursor.getString(2)
                val password = cursor.getString(3)

                user = Details(phone, name, location, password)

            }
        }
        return user
    }

}