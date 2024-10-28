package com.example.myapitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapitest.databinding.ActivityMainBinding
import com.example.myapitest.databinding.ActivityNewCarBinding

class NewCarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object {
        fun newIntent(context: Context) = Intent(context, NewCarActivity::class.java)
    }
}