package com.example.homework11

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework11.databinding.ActivityMainBinding
import com.example.homework11.databinding.AnimalItemBinding

class AnimalRecyclerViewAdapter(val animals: MutableList<Animal>): RecyclerView.Adapter<AnimalRecyclerViewAdapter.AnimalHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        return AnimalHolder(AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        var animal = animals[position]
        holder.binding.animalImage.setImageResource(animal.icon)
    }



    inner class AnimalHolder(var binding: AnimalItemBinding): RecyclerView.ViewHolder(binding.root){


    }
}