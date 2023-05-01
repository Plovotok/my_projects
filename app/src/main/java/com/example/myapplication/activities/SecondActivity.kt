package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun goToManGroups(view: View){
        val manAct = Intent(this, ManGroupsActivity::class.java)
        startActivity(manAct)
    }

    fun goToWomanGroups(view: View){
        val womanAct = Intent(this, WomanGroupsActivity::class.java)
        startActivity(womanAct)
    }
}