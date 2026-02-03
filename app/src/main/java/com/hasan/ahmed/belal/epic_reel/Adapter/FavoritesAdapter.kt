package com.hasan.ahmed.belal.epic_reel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.ahmed.belal.epic_reel.R

class FavoritesAdapter(
    private val favoriteItems: MutableList<FavoriteItem>,
    private val onRemoveClick: (item: FavoriteItem, position: Int) -> Unit
) : RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {

    inner class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
        val itemTitle: TextView = itemView.findViewById(R.id.item_title)
        val itemGenre: TextView = itemView.findViewById(R.id.item_genre)
        val itemDuration: TextView = itemView.findViewById(R.id.item_duration)
        val itemRemove: TextView = itemView.findViewById(R.id.item_remove)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val currentItem = favoriteItems[position]


        holder.itemImage.setImageResource(currentItem.imageResource)
        holder.itemTitle.text = currentItem.title
        holder.itemGenre.text = currentItem.genre
        holder.itemDuration.text = currentItem.duration


        holder.itemRemove.setOnClickListener {
            onRemoveClick(currentItem, holder.adapterPosition)
        }
    }
    override fun getItemCount(): Int {
        return favoriteItems.size
    }
    data class FavoriteItem(
        val id: Int,
        val imageResource: Int,
        val title: String,
        val genre: String,
        val duration: String
    )
}