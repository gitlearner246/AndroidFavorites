package com.example.favorites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.favorites.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = listOf(
            "Sakurairo", "タベザカリハルト", "やみあがりけん", "太陽はらっぱ", "音谷一本串", "なにわバナナ", "ほうき星みぞれ", "準決まける", "ぜんぜん"
        )

        binding.listView.adapter = ArrayAdapter(
        this,
        android.R.layout.simple_list_item_1,
        data
        )

        binding.listView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this@MainActivity, "${data[position]}を選択しました",
                Toast.LENGTH_SHORT).show()
        }
    }


}