package com.example.marsrealestatedemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.marsrealestatedemo.R
import com.example.marsrealestatedemo.local.Mars

class DetailViewModel(mars: Mars, application: Application) : AndroidViewModel(application) {

    private val _selectedProperty = MutableLiveData<Mars>()
    val selectedProperty: LiveData<Mars>
        get() = _selectedProperty

    init {
        _selectedProperty.value = mars
    }


    val displayPropertyPrice = Transformations.map(selectedProperty) {
        application.applicationContext.getString(
            when (it.isRental) {
                true -> R.string.display_price_monthly_rental
                false -> R.string.display_price
            }, it.price
        )
    }

    val displayPropertyType = Transformations.map(selectedProperty) {
        application.applicationContext.getString(
            R.string.display_type,
            application.applicationContext.getString(
                when (it.isRental) {
                    true -> R.string.display_price_monthly_rental
                    false -> R.string.display_price
                }, it.price
            )
        )
    }

}