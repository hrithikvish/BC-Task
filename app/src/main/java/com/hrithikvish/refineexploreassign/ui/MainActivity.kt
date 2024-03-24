package com.hrithikvish.refineexploreassign.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hrithikvish.refineexploreassign.R
import com.hrithikvish.refineexploreassign.adapters.HomeTabNavViewPagerAdapter
import com.hrithikvish.refineexploreassign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding

    lateinit var homeTabNavViewPagerAdapter : HomeTabNavViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        homeTabNavViewPagerAdapter = HomeTabNavViewPagerAdapter(supportFragmentManager)

        binding.refineBtn.setOnClickListener {
            startActivity(Intent(this, RefineActivity::class.java))
        }

        binding.homeTabNavVP.adapter = homeTabNavViewPagerAdapter
        binding.homeTabLayout.setupWithViewPager(binding.homeTabNavVP)

    }
}