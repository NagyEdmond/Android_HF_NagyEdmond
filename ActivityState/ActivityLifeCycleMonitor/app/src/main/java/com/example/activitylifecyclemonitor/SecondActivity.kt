package com.example.activitylifecyclemonitor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener{
            val intent = Intent(this@SecondActivity, ThirdActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Second", "Started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Second", "Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Second", "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Second", "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Second", "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Second", "Destroyed")
    }
}