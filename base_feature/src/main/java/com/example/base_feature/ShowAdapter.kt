package com.example.base_feature

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.base_feature.model.ShowPresentation

class ShowAdapter(
    private val callback: (ShowPresentation) -> Unit
) : RecyclerView.Adapter<ShowAdapter.ShowsViewHolder>() {

    private var shows: List<ShowPresentation> = emptyList()

    inner class ShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(show: ShowPresentation) {
            itemView.findViewById<AppCompatTextView>(R.id.titleShow).text =
                show.name

            val imageView = itemView.findViewById<AppCompatImageView>(R.id.imageShow)
            itemView.setOnClickListener { callback.invoke(show) }

            Glide
                .with(itemView)
                .load(show.image.original)
                .placeholder(R.drawable.ic_broken_image)
                .into(imageView)
/*
            val favImageView = itemView.findViewById<AppCompatImageView>(R.id.buttonFavorite)
            if (show.favorite) {
                favImageView.setImageResource(R.drawable.ic_favorite)
            } else {
                favImageView.setImageResource(R.drawable.ic_not_favorite)
            }


            favImageView.setOnClickListener {
                callbackLike.invoke(show, show.favorite)
                if (show.favorite) {
                    show.favorite = false
                    favImageView.setImageResource(R.drawable.ic_not_favorite)
                } else {
                    show.favorite = true
                    favImageView.setImageResource(R.drawable.ic_favorite)
                }

            }

             */


        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShowsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_show, parent, false)
        return ShowsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        holder.bind(shows[position])
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    fun setItems(list: List<ShowPresentation>) {
        shows = list
    }
}