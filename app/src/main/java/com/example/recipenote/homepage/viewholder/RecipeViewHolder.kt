package com.example.recipenote.homepage.viewholder

import android.util.Log
import android.widget.Toast
import com.example.recipenote.BaseViewHolderItem
import com.example.recipenote.databinding.RecipeListItemBinding
import com.example.recipenote.model.RecipeModel

class RecipeViewHolder(private val mBinding:RecipeListItemBinding):BaseViewHolderItem<RecipeModel>(mBinding.root) {
    override fun onCreated() {
    }

    override fun onBind(data: RecipeModel) {
        Log.i("recipe ","data from   $data")
        mBinding.data?.setData(data)
    }

}