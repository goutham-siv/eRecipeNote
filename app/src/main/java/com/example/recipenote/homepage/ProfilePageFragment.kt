package com.example.recipenote.homepage

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.recipenote.MainActivity
import com.example.recipenote.Utils.setRxOnClickListener
import com.example.recipenote.databinding.FragmentProfilePageFramentBinding
import com.example.recipenote.viewmodel.LoginViewModel
import com.example.recipenote.viewobserver.ProfileViewObserver
import kotlinx.android.synthetic.main.fragment_profile_page_frament.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ProfilePageFragment : Fragment() {

    private  val mViewModel:LoginViewModel by sharedViewModel()
    private  var mViewObserver =ProfileViewObserver()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =FragmentProfilePageFramentBinding.inflate(inflater,container,false)
        binding.data = mViewObserver
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadButtonFunctionality()
    }

    private fun loadButtonFunctionality() {

        mViewModel.getList().observe(this, Observer {
            it?.let{
                mViewObserver.setLogin(it)

            }

            })
        btnLogout.setRxOnClickListener {
            GlobalScope.launch(Dispatchers.IO) {
                mViewModel.deleteAccount()
                delay(1000)
                activity?.finishAffinity()
                startActivity(Intent(context!!,MainActivity::class.java))
            }

        }
    }


}