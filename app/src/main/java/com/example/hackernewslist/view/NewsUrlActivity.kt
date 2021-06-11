package com.example.hackernewslist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.hackernewslist.R

class NewsUrlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_url)

       supportActionBar.let {
           supportActionBar?.setDisplayHomeAsUpEnabled(true)
       }

        if (savedInstanceState == null) {

            val fragment = NewsUrlFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(NewsUrlFragment.NEW_ITEM,
                        intent.getSerializableExtra(NewsUrlFragment.NEW_ITEM))
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.nested,fragment)
                .commit()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}