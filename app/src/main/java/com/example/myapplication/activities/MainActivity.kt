package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun showRules(view: View) {
        val btn_rules = findViewById<Button>(R.id.btn_rules)

        val mAlertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        mAlertDialogBuilder.setTitle("Rules")
        mAlertDialogBuilder.setMessage(R.string.game_rules)
        mAlertDialogBuilder.setCancelable(false)
        mAlertDialogBuilder.setPositiveButton("OK",) { _, _ ->
            Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
        }
        btn_rules.setOnClickListener { val mAlertDialog = mAlertDialogBuilder.create()
            mAlertDialog.show()
            }
    }

    fun goToSecondActivity(view: View){
        val secAct = Intent(this, SecondActivity::class.java)
        val myMessage = Toast.makeText(this, "Let's start", Toast.LENGTH_SHORT)
        myMessage.show()
        startActivity(secAct)
    }

}