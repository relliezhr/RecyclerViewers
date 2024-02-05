package com.example.recyclerviewers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Suppress("DEPRECATION")
class GridRecipeAdapter(private val listRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<GridRecipeAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: ListRecipeAdapter.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: MainActivity){
        this.onItemClickCallback = onItemClickCallback
    }


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): GridRecipeAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_grid_recipes, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridRecipeAdapter.GridViewHolder, position: Int) {
        val (name, recipe, photo) = listRecipes[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listRecipes[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listRecipes.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.item_img)
    }

    interface OnItemClickCallback : ListRecipeAdapter.OnItemClickCallback {
        override fun onItemClicked(data: Recipes)
    }
}