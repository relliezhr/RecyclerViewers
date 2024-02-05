package com.example.recyclerviewers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListRecipeAdapter.OnItemClickCallback {
    private var rvRecipes: RecyclerView? = null
    private val list: MutableList<Recipes> = mutableListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvRecipes = findViewById(R.id.food_recipes)
        rvRecipes?.setHasFixedSize(true)

        list.addAll(RecipesData.listData)
        showRecyclerList()
    }

    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }

    override fun onItemClicked(data: Recipes) {
        showSelectedRecipe(data)
    }

    private fun showRecyclerList() {
        rvRecipes?.layoutManager = LinearLayoutManager(this)

        val listRecipeAdapter = ListRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = listRecipeAdapter

        listRecipeAdapter.setOnItemClickCallback(this)
    }

    private fun showRecyclerGrid() {
        rvRecipes?.layoutManager = GridLayoutManager(this, 2)

        val gridRecipeAdapter = GridRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = gridRecipeAdapter

        gridRecipeAdapter.setOnItemClickCallback(this)
    }

    private fun showRecyclerCardView() {
        rvRecipes?.layoutManager = LinearLayoutManager(this)

        val cardViewRecipeAdapter = CardViewRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = cardViewRecipeAdapter
    }

    private fun showSelectedRecipe(recipes: Recipes) {
        val moveData = Intent(this@MainActivity, RecipePage::class.java)

        moveData.putExtra("recipeName", recipes.name)
        moveData.putExtra("recipeDescription", recipes.recipe)
        moveData.putExtra("recipePhoto", recipes.photo)

        startActivity(moveData)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
                return true
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
                return true
            }

            R.id.action_cardview -> {
                title = "Mode Card View"
                showRecyclerCardView()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}