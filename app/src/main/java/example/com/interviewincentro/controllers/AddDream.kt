package example.com.interviewincentro.controllers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import example.com.interviewincentro.R
import example.com.interviewincentro.db.DatabaseAccess
import example.com.interviewincentro.models.Dream
import kotlinx.android.synthetic.main.activity_add_dream.*


class AddDream : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_dream)

    }
    fun saveDream(view: View){
        validate()
    }

    private fun validate() {


        if(add_title.text.toString().equals("") || add_day.text.toString().equals("") ||
                add_description.text.toString().equals("")){
            Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show()
        }else{
            var  a_label: String?="no label"

            val a_title = add_title.text.toString()
            val a_desc = add_description.text.toString()
            val a_day = add_day.text.toString()

            if(add_specifyET.text.equals("")){
                  a_label = add_labelSpinner.selectedItem.toString()

            }else{
                a_label = add_specifyET.text.toString()

            }


            val fDream = Dream(a_title,a_day,a_desc,a_label)

            DatabaseAccess(this).sendToDb(fDream)



        }

    }
}
