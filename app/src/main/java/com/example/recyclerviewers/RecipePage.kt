package com.example.recyclerviewers

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class RecipePage : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "CutPasteId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val tvRecipeName: TextView = findViewById(R.id.item_name)
        val tvMaterials: TextView = findViewById(R.id.materials)
        val tvRecipeDesc: TextView = findViewById(R.id.item_recipes)
        val imageView: ImageView = findViewById(R.id.item_img)

        val recipeName = intent.getStringExtra("recipeName")
        val recipeDescription = intent.getStringExtra("recipeDescription")
        val recipePhoto = intent.getStringExtra("recipePhoto")

        tvRecipeName.text = recipeName
        tvMaterials.text = "Bahan:"
        tvRecipeDesc.text = recipeDescription

        if (recipePhoto != null) {
            Glide.with(this)
                .load(recipePhoto)
                .apply(RequestOptions())
                .into(imageView)
        } else {
            val resourceId = intent.getIntExtra("recipePhoto", 0)
            if (resourceId != 0) {
                imageView.setImageResource(resourceId)
            }
        }


    }
}
