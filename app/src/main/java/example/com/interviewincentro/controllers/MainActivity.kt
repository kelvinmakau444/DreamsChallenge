package example.com.interviewincentro.controllers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import example.com.interviewincentro.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToMyDreams(view: View){
        startActivity(Intent(this,MyDreams::class.java))
    }
    fun goToAddDream(view: View){
        startActivity(Intent(this,AddDream::class.java))
    }
}
