package com.hrithikvish.refineexploreassign.ui

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hrithikvish.refineexploreassign.R
import com.hrithikvish.refineexploreassign.databinding.ActivityRefineBinding

class RefineActivity : AppCompatActivity() {
    lateinit var binding:ActivityRefineBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRefineBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initToolBar()
        initAvailabilitySpinner()
        initLocalDistanceSeekBar()
        initStatusEt()

    }

    private fun initAvailabilitySpinner() {
        ArrayAdapter.createFromResource(
            this,
            R.array.refine_availability_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.availabilitySpinner.adapter = adapter
        }
    }

    private fun initToolBar() {
        binding.toolBar.setNavigationIcon(R.drawable.icon_back_arrow)
        binding.toolBar.setNavigationIconTint(Color.WHITE)
        binding.toolBar.setNavigationOnClickListener { finish() }
    }

    private fun initStatusEt() {
        binding.statusLength.text = binding.statusEt.text.length.toString()
        binding.statusEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.statusLength.text = binding.statusEt.text.length.toString()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    private fun initLocalDistanceSeekBar() {
        binding.seekbar.progress = 50
        binding.seekbar.viewTreeObserver.addOnGlobalLayoutListener {
            val thumbPos =
                binding.seekbar.paddingLeft + (binding.seekbar.width - binding.seekbar.paddingLeft - binding.seekbar.paddingRight) * binding.seekbar.progress / binding.seekbar.max

            binding.distanceSeekbarValue.x =
                binding.seekbar.x + thumbPos - binding.distanceSeekbarValue.measuredWidth / 2

            binding.distanceSeekbarValue.text = binding.seekbar.progress.toString()
        }
        binding.seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                binding.distanceSeekbarValue.text = progress.toString()

                seekbar?.let { seekBar ->
                    val width = seekBar.width - seekBar.paddingLeft - seekBar.paddingRight
                    val thumbPos = seekBar.paddingLeft + width * seekBar.progress / seekBar.max

                    binding.distanceSeekbarValue.measure(0, 0)
                    val txtW = binding.distanceSeekbarValue.measuredWidth
                    val delta = txtW / 2

                    binding.distanceSeekbarValue.x = seekBar.x + thumbPos - delta
                }

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}

        })
    }
}