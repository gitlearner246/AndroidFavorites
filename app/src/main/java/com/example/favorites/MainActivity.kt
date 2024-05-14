package com.example.favorites

import android.content.Intent
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.favorites.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listView.adapter = SimpleAdapter(
            this,
            listData,
            R.layout.list_item,
            arrayOf("image", "name"),
            intArrayOf(R.id.image, R.id.name)
        )

        binding.listView.setOnItemClickListener { _, _, position, _ ->
            startActivity(
                Intent(this@MainActivity, DetailActivity::class.java).apply {
                    putExtra("POSITION", position)
                }
            )
        }
    }
}