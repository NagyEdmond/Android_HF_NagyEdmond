package com.example.activitylifecyclemonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Third", "Started")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Third", "Restarted")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Third", "Resumed")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Third", "Paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Third", "Stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Third", "Destroyed")
    }
}