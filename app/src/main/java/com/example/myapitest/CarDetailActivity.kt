package com.example.myapitest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapitest.databinding.ActivityCarDetailBinding
import com.example.myapitest.databinding.ActivityMainBinding

class CarDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    companion object {
        private const val ARG_ID = "ARG_ID"

        fun newIntent(
            context: Context,
            itemId: String
        ) = Intent(context, CarDetailActivity::class.java).apply {
            putExtra(ARG_ID, itemId)
        }

    }
}