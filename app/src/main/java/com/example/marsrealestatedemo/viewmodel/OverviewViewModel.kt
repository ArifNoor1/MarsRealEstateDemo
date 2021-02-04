package com.example.marsrealestatedemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsrealestatedemo.enumpackage.MarsFilter
import com.example.marsrealestatedemo.enumpackage.MarsStatus
import com.example.marsrealestatedemo.local.Mars
import com.example.marsrealestatedemo.remote.Networking
import kotlinx.coroutines.launch
import java.util.ArrayList


class OverviewViewModel : ViewModel(){

    private val _status = MutableLiveData<MarsStatus>()
    val status : LiveData<MarsStatus>
    get() = _status

    private val _properties = MutableLiveData<List<Mars>>()
    val properties: LiveData<List<Mars>>
    get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<Mars>()
    val navigateToSelectedProperty : LiveData<Mars>
    get() = _navigateToSelectedProperty

    init {
        getMarsRealEstateProperties(MarsFilter.SHOW_ALL)
    }

    private fun getMarsRealEstateProperties(filter: MarsFilter){
        viewModelScope.launch {
            _status.value = MarsStatus.LOADING
            try {
                _properties.value = Networking.retrofitService.getProperties(filter.value)
                _status.value = MarsStatus.DONE
            } catch (e: Exception){
                _status.value = MarsStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun updateFilter(filter: MarsFilter){
        getMarsRealEstateProperties(filter)
    }

    fun displayPropertyDetails(mars: Mars){
        _navigateToSelectedProperty.value = mars
    }

    fun displayPropertyDetailsComplete(){
        _navigateToSelectedProperty.value = null
    }





}