package com.example.recipenote.homepage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.recipenote.Utils.setRxOnClickListener
import com.example.recipenote.databinding.FragmentWriteYourRecipeBinding
import com.example.recipenote.model.RecipeModel
import com.example.recipenote.viewmodel.RecipeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class WriteYourRecipe : Fragment() {

    private lateinit var mViewBinding: FragmentWriteYourRecipeBinding
    private  val mViewModel:RecipeViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = FragmentWriteYourRecipeBinding.inflate(inflater, container, false)
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadButtonFunctionality()
    }

    private fun loadButtonFunctionality() {
        mViewBinding.btnSubmit.setRxOnClickListener {
            if (!mViewBinding.etHowToMake.text.isNullOrEmpty() || !mViewBinding.etIngredients.text.isNullOrEmpty() || !mViewBinding.etRecipe.text.isNullOrEmpty()) {

                GlobalScope.launch(Dispatchers.IO) {
                    mViewModel.setItemList(
                        RecipeModel(
                            mViewBinding.etRecipe.text.toString(),
                            mViewBinding.etIngredients.text.toString(),
                            mViewBinding.etHowToMake.text.toString()
                        )

                    )
                    delay(3000L)
                    findNavController().navigateUp()

                }
            }
        }
    }
}