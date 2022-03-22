package com.himanshu.sample

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(): RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Movie>()
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_movie, parent, false)
        val viewHolder = MainViewHolder(view)
        return viewHolder
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.name.text = movie.name
        Glide.with(holder.itemView.context).load(movie.imageUrl).into(holder.image)
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.name)
    val image: ImageView = itemView.findViewById(R.id.imageview)
}