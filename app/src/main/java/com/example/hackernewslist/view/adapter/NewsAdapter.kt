package com.example.hackernewslist.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackernewslist.R
import com.example.hackernewslist.model.New
import com.example.hackernewslist.view.MainActivity
import com.example.hackernewslist.view.NewsUrlActivity
import com.example.hackernewslist.view.NewsUrlFragment
import java.text.SimpleDateFormat
import java.util.*

class NewsAdapter(private val parent: MainActivity, private val news: MutableList<New>): RecyclerView.Adapter<MainViewHolder>() {

    private var newsList = mutableListOf<New>()

    private val onClickListener: View.OnClickListener = View.OnClickListener {

        val item = it.tag as New

        val intent = Intent(it.context, NewsUrlActivity::class.java).apply {
            putExtra(NewsUrlFragment.NEW_ITEM,item.url)
        }
        it.context.startActivity(intent)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_view, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val new = news[position]


        holder.title.text = new.title?: "No title"

        val dateTime = new.createdAt
        val pattern = "dd-MM-yyyy"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date:String = simpleDateFormat.parse(dateTime).toString()
        var realDate = " - ${date.split("00:00:00")[0]?:"No date"}"
        val author = new.author + realDate
        holder.author.text = author

        with(holder.itemView) {
            tag = new
            setOnClickListener(onClickListener)
        }

    }

    fun deleteNew(position: Int){
        news.removeAt(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return news.size
    }


}

 class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.title)
    val author = view.findViewById<TextView>(R.id.author)


}