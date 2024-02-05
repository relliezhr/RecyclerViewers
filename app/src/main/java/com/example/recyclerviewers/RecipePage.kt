package com.example.recyclerviewers

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class RecipePage: Activity(){
    @SuppressLint("WrongViewCast", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val tvRecipeName: TextView = findViewById(R.id.recipe_name)
        val tvRecipeDesc: TextView = findViewById(R.id.recipe_desc)

        val recipeName = intent.getStringExtra("recipeName")
        val recipeDescription = intent.getStringExtra("recipeDescription")
        val recipePhoto = intent.getIntExtra("recipePhoto", 0)

        if (recipePhoto != 0) {
            val imageView: ImageView = findViewById(R.id.recipe_name)
            imageView.setImageResource(recipePhoto)

            tvRecipeName.text = recipeName
            tvRecipeDesc.text = recipeDescription
        }
    }
}