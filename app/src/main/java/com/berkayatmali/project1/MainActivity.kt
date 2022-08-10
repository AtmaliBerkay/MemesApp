package com.berkayatmali.project1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berkayatmali.project1.databinding.ActivityMainBinding
import com.berkayatmali.project1.ui.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.flMain, HomeFragment.newInstance())
                .commitNow()
        }
    }
}