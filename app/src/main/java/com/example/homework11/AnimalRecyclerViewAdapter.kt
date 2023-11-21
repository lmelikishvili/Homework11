package com.example.homework11

import android.content.Context
import android.content.Intent
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

        private var animalBtn = binding.animalImage
        init {
            val context: Context = binding.root.context
            animalBtn.setOnClickListener(){
                val intent = Intent(context,AnimaView::class.java)
                with(intent) {
                    putExtra("title", animals[adapterPosition].title)
                    putExtra("desc", animals[adapterPosition].desc)
                    putExtra("icon", animals[adapterPosition].icon)
                }
                context.startActivity(intent)
            }
        }
    }
}