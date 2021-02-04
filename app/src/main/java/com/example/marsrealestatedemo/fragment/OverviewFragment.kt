package com.example.marsrealestatedemo.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marsrealestatedemo.R
import com.example.marsrealestatedemo.adapter.PhotoGridAdapter
import com.example.marsrealestatedemo.databinding.FragmentOverviewBinding
import com.example.marsrealestatedemo.databinding.GridViewItemBinding
import com.example.marsrealestatedemo.enumpackage.MarsFilter
import com.example.marsrealestatedemo.viewmodel.OverviewViewModel

class OverviewFragment : Fragment() {

    private val overviewViewModel : OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.overviewVM = overviewViewModel

        binding.photosGrid.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener {
            overviewViewModel.displayPropertyDetails(it)
        })

        overviewViewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            if (null != it){
                this.findNavController().navigate(
                    OverviewFragmentDirections.actionOverviewFragmentToDetailFragment())
                overviewViewModel.displayPropertyDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        overviewViewModel.updateFilter(
            when (item.itemId){
                R.id.show_rent_menu -> MarsFilter.SHOW_RENT
                R.id.show_buy_menu -> MarsFilter.SHOW_BUY
                else -> MarsFilter.SHOW_ALL
            }
        )
        return true
    }


}