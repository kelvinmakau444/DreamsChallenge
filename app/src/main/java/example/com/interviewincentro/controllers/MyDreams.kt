package example.com.interviewincentro.controllers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import example.com.interviewincentro.R
import example.com.interviewincentro.adapters.DreamsAdapter
import example.com.interviewincentro.db.DatabaseAccess
import example.com.interviewincentro.models.Dream
import kotlinx.android.synthetic.main.activity_my_dreams.*
import javax.xml.transform.dom.DOMResult

class MyDreams : AppCompatActivity() {

    lateinit var mDreams  :List<Dream>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_dreams)
      //  setup
        mDreams = getDreams()
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mydreamsRV.layoutManager = manager
        mydreamsRV.setHasFixedSize(true)
        mydreamsRV.adapter = DreamsAdapter(this, mDreams) { dream ->
            startActivity(Intent(this,DreamDetails::class.java).putExtra("dream",dream))



        }

    }

    private fun getDreams(): List<Dream> {

        return DatabaseAccess(this).savedDream

    }


    }


