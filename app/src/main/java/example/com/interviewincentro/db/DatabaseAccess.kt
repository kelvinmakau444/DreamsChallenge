package example.com.interviewincentro.db

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import android.widget.Toast

import java.util.ArrayList

import example.com.interviewincentro.models.Dream

/**
 * Created by Acer on 12/21/2017.
 */

class DatabaseAccess(internal var context: Context) {
    private var db: SQLiteDatabase? = null

    val savedDream: ArrayList<Dream>
        get() {
            val list = ArrayList<Dream>()
            open()
            var cursor: Cursor? = null
            val query = "SELECT *  FROM Dream"
            try {
                cursor = db!!.rawQuery(query, null)
                if (cursor!!.moveToFirst()) {
                    do {
                        var title = (cursor.getString(cursor.getColumnIndex("title")))
                        var day  = (cursor.getString(cursor.getColumnIndex("day")))
                        var description =(cursor.getString(cursor.getColumnIndex("description")))
                        var label = (cursor.getString(cursor.getColumnIndex("label")))

                        var fDream = Dream(title,day,description,label)



                        list.add(fDream)

                    } while (cursor.moveToNext())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (cursor != null && !cursor.isClosed) {
                    cursor.close()
                }
            }
            db!!.close()
            return list
        }


    init {
        db = context.openOrCreateDatabase("DreamsDB", Context.MODE_PRIVATE, null)

    }


    fun sendToDb(fDream: Dream) {
        open()

        db!!.execSQL("CREATE TABLE IF NOT EXISTS Dream(title VARCHAR UNIQUE,day VARCHAR,description VARCHAR,label VARCHAR);")




        try {
            val query = "INSERT  INTO Dream VALUES (${fDream.dreamtitle} ,${fDream.day} ,${fDream.description} ,${fDream.label});"
            db!!.execSQL(query)
            Toast.makeText(context, "Successfully saved to your dream list", Toast.LENGTH_LONG).show()

        } catch (e: SQLiteException) {
            Log.d("SQERR:",e.toString())
              Toast.makeText(context, "Error: "+e.toString(), Toast.LENGTH_LONG).show();

            Toast.makeText(context, "Failed!... something went wrong", Toast.LENGTH_LONG).show()
        }

        db!!.close()
    }

    fun open() {
        db = context.openOrCreateDatabase("DreamDB", Context.MODE_PRIVATE, null)
    }
}