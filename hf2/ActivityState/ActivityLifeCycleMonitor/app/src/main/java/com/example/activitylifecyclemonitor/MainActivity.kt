package com.example.activitylifecyclemonitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main", "Started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Main", "Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Main", "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Main", "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Main", "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Main", "Destroyed")
    }
}