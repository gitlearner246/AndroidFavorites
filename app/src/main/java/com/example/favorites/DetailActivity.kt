package com.example.favorites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.favorites.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("POSITION", 0)

        val data = listData[position]
        val name = data["name"].toString()
        val birthday = data["birthday"].toString()
        val explain = resources.getString(data["explain"].toString().toInt())

        binding.detailImage.setImageResource(data["image"].toString().toInt())
        binding.detailName.text = name
        binding.detailBirthday.text = getString(R.string.label_birthday, birthday)
        binding.detailExplain.text = explain

        binding.btnShare.setOnClickListener {
            val subject = "【${name}】をおすすめ"
            val message = "推しの名前：${name}\n誕生日：${birthday}\n\n${explain}"

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_SUBJECT, subject)
                putExtra(Intent.EXTRA_TEXT, message)
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}