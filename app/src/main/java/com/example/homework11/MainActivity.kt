package com.example.homework11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.homework11.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var animals = mutableListOf<Animal>()
    private lateinit var search: SearchView
    private var searchList = mutableListOf<Animal>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        search = binding.searchView
        setContentView(binding.root)
        setupAnimals()

        //binding.animalRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.animalRecyclerView.layoutManager = GridLayoutManager(this,3)
        binding.animalRecyclerView.adapter = AnimalRecyclerViewAdapter(animals = searchList)

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                search.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                if (newText!!.isNotEmpty()){
                    animals.forEach{
                        if (it.title == newText){
                            searchList.add(it)
                        }
                    }
                    binding.animalRecyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    searchList.clear()
                    searchList.addAll(animals)
                    binding.animalRecyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
    }

    private fun setupAnimals(){
        animals.also {
            it.add(Animal("dog1", "dog1", R.drawable.dog1))
            it.add(Animal("dog2", "dog2", R.drawable.dog2))
            it.add(Animal("dog3", "dog3", R.drawable.dog3))
            it.add(Animal("dog4", "dog4", R.drawable.dog4))
            it.add(Animal("dog5", "dog5", R.drawable.dog5))
            it.add(Animal("dog6", "dog6", R.drawable.dog6))
            it.add(Animal("dog7", "dog7", R.drawable.dog7))
            it.add(Animal("dog8", "dog8", R.drawable.dog8))
            it.add(Animal("dog9", "dog9", R.drawable.dog9))
            it.add(Animal("dog10", "dog10", R.drawable.dog10))
            it.add(Animal("dog11", "dog11", R.drawable.dog11))
            it.add(Animal("dog12", "dog12", R.drawable.dog12))
            it.add(Animal("dog13", "dog13", R.drawable.dog13))
            it.add(Animal("dog14", "dog14", R.drawable.dog14))
            it.add(Animal("dog15", "dog15", R.drawable.dog15))
        }
        searchList.addAll(animals)
    }
}