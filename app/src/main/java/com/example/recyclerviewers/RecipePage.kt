package com.example.recyclerviewers

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class RecipePage: Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val tvRecipeName: TextView = findViewById<TextView>(R.id.item_name)
        val tvRecipeDesc: TextView = findViewById<TextView>(R.id.item_recipes)

        val recipeName = intent.getStringExtra("recipeName")
        val recipeDescription = intent.getStringExtra("recipeDescription")
        val recipePhoto = intent.getIntExtra("recipePhoto", 0)

        if (recipePhoto != 0) {
            val imageView: ImageView = findViewById(R.id.item_img)
            imageView.setImageResource(recipePhoto)

            tvRecipeName.text = recipeName
            tvRecipeDesc.text = recipeDescription
        }
    }
}