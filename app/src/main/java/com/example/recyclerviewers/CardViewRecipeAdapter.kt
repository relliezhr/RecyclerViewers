package com.example.recyclerviewers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Suppress("DEPRECATION")
class CardViewRecipeAdapter(private val listRecipes: ArrayList<Recipes>):
    RecyclerView.Adapter<CardViewRecipeAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cardview_recipes, viewGroup, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val (name, recipe, photo) = listRecipes[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRecipes.text = recipe

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listRecipes[holder.adapterPosition]) }

        holder.btnFavorite.setOnClickListener{Toast.makeText(holder.itemView.context, "Favorite " + listRecipes[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}
        holder.btnShare.setOnClickListener{Toast.makeText(holder.itemView.context, "Share " + listRecipes[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()}
    }

    override fun getItemCount(): Int {
        return listRecipes.size
    }

    inner class CardViewViewHolder(itemView: View):  RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.item_name)
        var tvRecipes: TextView = itemView.findViewById(R.id.item_recipes)
        var imgPhoto: ImageView = itemView.findViewById(R.id.item_img)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Recipes)

    }
}