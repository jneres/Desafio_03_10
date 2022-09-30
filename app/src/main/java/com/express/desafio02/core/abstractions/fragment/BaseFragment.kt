package com.express.desafio02.core.abstractions.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.express.desafio02.core.abstractions.navigation.navigateAnimation
import com.express.desafio02.MainActivity

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment() {

    var binding: Binding? = null

    abstract fun layout(): Int

    abstract fun init()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, layout(), container, false)
        binding?.lifecycleOwner = this
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showLoading(true)
        init()
    }

    fun showLoading(show: Boolean) {
        (activity as MainActivity).showLoading(show)
    }

    open fun onBackPressed(): Boolean {
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    fun navigate(id: Int, bundle: Bundle? = null) {
        findNavController().navigateAnimation(id, bundle)
    }

    //navi Directions
    fun navigate(args: NavDirections) {
        findNavController().navigateAnimation(args)
    }


}
