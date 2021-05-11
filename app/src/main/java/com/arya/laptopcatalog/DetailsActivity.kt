package com.arya.laptopcatalog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arya.laptopcatalog.databinding.ActivityDetailsBinding
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LAPTOP = "extra_laptop"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.title = "Detail Laptop"
        }

        val laptop = intent.getParcelableExtra<Laptop>(EXTRA_LAPTOP) as Laptop

        Glide.with(this)
            .load(laptop.photo)
            .into(binding.imgPhoto)
        binding.tvName.text = laptop.name
        binding.tvDetail.text = laptop.detail
        binding.tvPrice.text = laptop.price
        binding.btnInfo.setOnClickListener {
            val url = laptop.site
            val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(openUrlIntent)
        }
        binding.btnShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, """
                    ${laptop.name} - ${laptop.detail}
                    
                    Info lebih lanjut : 
                    ${laptop.site}
                """.trimIndent())
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}