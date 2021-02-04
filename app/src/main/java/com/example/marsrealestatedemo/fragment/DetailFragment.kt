package com.example.marsrealestatedemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestatedemo.databinding.FragmentDetailBinding
import com.example.marsrealestatedemo.factory.DetailViewModelFactory
import com.example.marsrealestatedemo.viewmodel.DetailViewModel

class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
//        val mars = DetailFragmentArgs.fromBundle(arguments).selectedProperty
//        val viewModelFactory = DetailViewModelFactory(mars, application)
//        binding.detailVM =
//            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        return binding.root
    }
}