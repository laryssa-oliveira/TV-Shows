package com.example.feature_favorite.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.base_feature.R
import com.example.base_feature.model.ShowPresentation

class FavoriteShowAdapter(
    private val callback: (ShowPresentation) -> Unit,
    private val callbackLike: (like: Boolean, show: ShowPresentation) -> Unit,
    private val callbackUpdateUi: (shows: MutableList<ShowPresentation>) -> Unit
) : RecyclerView.Adapter<FavoriteShowAdapter.ShowsViewHolder>() {

    private var shows: MutableList<ShowPresentation> = mutableListOf()

    inner class ShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(show: ShowPresentation) {
            itemView.findViewById<AppCompatTextView>(R.id.titleShow).text =
                show.name

            val imageView = itemView.findViewById<AppCompatImageView>(R.id.imageShow)
            itemView.setOnClickListener { callback.invoke(show) }

            val favImageView = itemView.findViewById<AppCompatImageView>(R.id.favShow)
            if (show.favorite) {
                favImageView.setImageResource(R.drawable.ic_favorite)
            } else {
                favImageView.setImageResource(R.drawable.ic_not_favorite)
            }

            favImageView.setOnClickListener {
                callbackLike.invoke(show.favorite, show)
                if (show.favorite) {
                    show.favorite = false
                    notifyItemRemoved(adapterPosition)
                    shows.remove(show)
                    callbackUpdateUi.invoke(shows)
                    favImageView.setImageResource(R.drawable.ic_not_favorite)
                } else {
                    show.favorite = true
                    favImageView.setImageResource(R.drawable.ic_favorite)
                }

            }

            Glide
                .with(itemView)
                .load(show.image)
                .placeholder(R.drawable.ic_broken_image)
                .into(imageView);
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

    fun setItems(list: MutableList<ShowPresentation>) {
        shows = list
    }
}