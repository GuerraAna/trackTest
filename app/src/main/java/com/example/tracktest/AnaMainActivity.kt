package com.example.tracktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tracktest.databinding.ActivityMainBinding
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase

class AnaMainActivity : AppCompatActivity() {
    private lateinit var analytics: FirebaseAnalytics
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        analytics = Firebase.analytics
        binding.button.setOnClickListener {
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM) {
                param(FirebaseAnalytics.Param.ITEM_ID, "id")
                param(FirebaseAnalytics.Param.ITEM_NAME, "name")
                param(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
            }
        }
    }
}