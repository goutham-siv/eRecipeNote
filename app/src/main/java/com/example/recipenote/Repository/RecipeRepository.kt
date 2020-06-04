package com.example.recipenote.Repository

import androidx.room.Dao
import com.example.recipenote.model.RecipeModel
import com.example.recipenote.repository.db.api.AppDatabase


@Dao
class RecipeRepository (    private val mAppDatabase: AppDatabase)
{
    /***
     * get List
     */
    fun  getRecipeList()=mAppDatabase.recipeDao().getAlphabetizedWords()

    /**
     * set Item
     */
    fun setItemList(Recipe :RecipeModel)=mAppDatabase.recipeDao().insert(Recipe)
}