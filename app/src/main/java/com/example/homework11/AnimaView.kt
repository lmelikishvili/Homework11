package com.example.homework11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework11.databinding.ActivityAnimaViewBinding
import com.example.homework11.databinding.AnimalItemBinding

class AnimaView : AppCompatActivity() {
    private lateinit var binding: ActivityAnimaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData(){
        val intent = intent
        val title = intent.getStringExtra("title")
        val desc = intent.getStringExtra("desc")
        val icon = intent.getIntExtra("icon",0)

        binding.animalTitle.text = title
        binding.animalDesc.text = desc
        icon?.let { binding.imageView.setImageResource(it) }
    }
}