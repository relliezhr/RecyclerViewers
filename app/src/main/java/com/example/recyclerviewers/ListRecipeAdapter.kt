package com.example.recyclerviewers

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Suppress("DEPRECATION")
class ListRecipeAdapter(private val listRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<ListRecipeAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_recipes, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, recipe, photo) = listRecipes[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRecipes.text = recipe

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listRecipes[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listRecipes.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.item_name)
        var tvRecipes: TextView = itemView.findViewById(R.id.item_recipes)
        var imgPhoto: ImageView = itemView.findViewById(R.id.item_img)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Recipes)
    }
}