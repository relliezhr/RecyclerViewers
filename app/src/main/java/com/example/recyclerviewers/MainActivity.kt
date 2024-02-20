package com.example.recyclerviewers

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var rvRecipes: RecyclerView? = null
    private val list: MutableList<Recipes> = mutableListOf()
    private var title: String = "Resep Nusantara"
    private lateinit var listRecipeAdapter: ListRecipeAdapter
    private lateinit var gridRecipeAdapter: GridRecipeAdapter
    private lateinit var cardViewRecipeAdapter: CardViewRecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitleAndAppName(title)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        rvRecipes = findViewById(R.id.food_recipes)
        rvRecipes?.setHasFixedSize(true)

        list.addAll(RecipesData.listData)
        showRecyclerList()
    }

    private fun setActionBarTitleAndAppName(title: String) {
        supportActionBar?.title = title
        setTitle(title)
    }

    private fun showRecyclerList() {
        rvRecipes?.layoutManager = LinearLayoutManager(this)

        listRecipeAdapter = ListRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = listRecipeAdapter

        listRecipeAdapter.setOnItemClickCallback(object : ListRecipeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Recipes) {
                showSelectedRecipe(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        rvRecipes?.layoutManager = GridLayoutManager(this, 2)

        gridRecipeAdapter = GridRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = gridRecipeAdapter

        gridRecipeAdapter.setOnItemClickCallback(object : GridRecipeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Recipes) {
                showSelectedRecipe(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        rvRecipes?.layoutManager = LinearLayoutManager(this)

        cardViewRecipeAdapter = CardViewRecipeAdapter(list as ArrayList<Recipes>)
        rvRecipes?.adapter = cardViewRecipeAdapter

        cardViewRecipeAdapter.setOnItemClickCallback(object : CardViewRecipeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Recipes) {
                showSelectedRecipe(data)
            }
        })

    }

    private fun showSelectedRecipe(recipes: Recipes) {
        Toast.makeText(this, "Kamu memilih " + recipes.name, Toast.LENGTH_SHORT).show()
        moveRecipePage(recipes)
    }

    private fun moveRecipePage(recipes: Recipes) {
        val moveData = Intent(this@MainActivity, RecipePage::class.java)
        val recipesName = recipes.name
        val recipesDesc = recipes.recipe
        val recipesPhoto = recipes.photo

        moveData.putExtra("recipeName", recipesName)
        moveData.putExtra("recipeDescription", recipesDesc)
        moveData.putExtra("recipePhoto", recipesPhoto)

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
                setActionBarTitleAndAppName(title)
                showRecyclerList()
                return true
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                setActionBarTitleAndAppName(title)
                showRecyclerGrid()
                return true
            }

            R.id.action_cardview -> {
                title = "Mode Card View"
                setActionBarTitleAndAppName(title)
                showRecyclerCardView()
                return true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }
}
