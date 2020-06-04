package com.example.recipenote.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.recipenote.Repository.RecipeRepository
import com.example.recipenote.model.RecipeModel

class  RecipeViewModel(private  val mRepository: RecipeRepository):ViewModel()
{
    /**
     * get Item
     */

    fun  getRecipeList()=mRepository.getRecipeList()

    /**
     * set Item
     */
    fun setItemList(Recipe : RecipeModel)=mRepository.setItemList(Recipe)
}