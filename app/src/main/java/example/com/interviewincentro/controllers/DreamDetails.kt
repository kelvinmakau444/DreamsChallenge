package example.com.interviewincentro.controllers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import example.com.interviewincentro.R
import example.com.interviewincentro.models.Dream
import kotlinx.android.synthetic.main.activity_dream_details.*

class DreamDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dream_details)


        var a_dream : Dream
        a_dream = intent.getParcelableExtra("dream")

        if(a_dream !=null){
            dreamdetail_titleTV.text=a_dream.dreamtitle
            dreamdetail_descriptionTV.text=a_dream.description
            dreamdetail_daylTV.text=a_dream.day
            dreamdetail_labelTV.text=a_dream.label

        }



    }
}
