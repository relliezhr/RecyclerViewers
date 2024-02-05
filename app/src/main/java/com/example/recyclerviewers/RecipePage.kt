package com.example.recyclerviewers

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipePage : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        val tvRecipeName: TextView = findViewById(R.id.recipe_name)
        val tvRecipeDesc: TextView = findViewById(R.id.recipe_desc)
        val imageView: ImageView = findViewById(R.id.recipe_photo)

        val recipeName = intent.getStringExtra("recipeName")
        val recipeDescription = intent.getStringExtra("recipeDescription")
        val recipePhoto = intent.getIntExtra("recipePhoto", 0)

        if (recipePhoto != 0) {
            imageView.setImageResource(recipePhoto)
            tvRecipeName.text = recipeName
            tvRecipeDesc.text = recipeDescription
        }
    }
}
