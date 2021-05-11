package com.arya.laptopcatalog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.arya.laptopcatalog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Laptop> = arrayListOf()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvLaptops.setHasFixedSize(true)

        list.addAll(LaptopsData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvLaptops.layoutManager = LinearLayoutManager(this)
        val listLaptopAdapter = ListLaptopAdapter(list)
        binding.rvLaptops.adapter = listLaptopAdapter

        listLaptopAdapter.setOnItemClickCallback(object : ListLaptopAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Laptop) {
                showSelectedLaptop(data)
            }
        })
    }

    private fun showSelectedLaptop(laptop: Laptop) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.EXTRA_LAPTOP, laptop)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            val menuIntent = Intent(this, AboutActivity::class.java)
            startActivity(menuIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}