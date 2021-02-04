package com.example.marsrealestatedemo.factory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.marsrealestatedemo.local.Mars
import com.example.marsrealestatedemo.viewmodel.DetailViewModel
import java.lang.IllegalArgumentException

class DetailViewModelFactory(private val mars: Mars, private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(mars, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}