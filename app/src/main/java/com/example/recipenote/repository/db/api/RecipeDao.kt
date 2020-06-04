package com.example.recipenote.repository.db.api
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipenote.model.RecipeModel


@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(login: RecipeModel)

    @Query("DELETE FROM RecipeModel")
    fun deleteAll()

    @Query("SELECT * from RecipeModel ORDER BY Recipe ASC")
    fun getAlphabetizedWords(): LiveData<MutableList<RecipeModel>>
}