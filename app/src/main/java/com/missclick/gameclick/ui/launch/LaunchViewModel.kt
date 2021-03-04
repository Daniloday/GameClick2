package com.missclick.gameclick.ui.launch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gameclick.App
import com.missclick.gameclick.clickRepository.ClickIRepository
import com.missclick.gameclick.clickRepository.ClickRepository
import javax.inject.Inject

class LaunchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var repository: ClickIRepository

    init {
        App.appComponent.inject(this)
    }
}