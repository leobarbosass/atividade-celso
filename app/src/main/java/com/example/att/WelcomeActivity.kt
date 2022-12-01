package com.example.att

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.att.databinding.ActivityMainBinding
import com.example.att.databinding.ActivityWelcomeBinding

class WelcomeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}