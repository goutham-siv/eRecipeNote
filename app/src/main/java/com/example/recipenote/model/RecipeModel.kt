package com.example.recipenote.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "RecipeModel")
data class RecipeModel(
    @PrimaryKey
    @ColumnInfo(name = "Recipe")var recipe:String,
    @ColumnInfo(name = "Ingredients")var Ingredients:String,
    @ColumnInfo(name = "howToMake")var howToMake:String
)