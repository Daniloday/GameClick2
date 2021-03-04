package com.missclick.gameclick.ui.win

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gameclick.App
import com.missclick.gameclick.clickRepository.ClickIRepository
import com.missclick.gameclick.data.ModelForDB
import javax.inject.Inject

class LoseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is slideshow Fragment"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var repository: ClickIRepository

    init {
        App.appComponent.inject(this)

    }

    fun lost(id : Int){
        val idi = id + 10
        repository.appendStats(ModelForDB(id = idi,player = "bob",score = id))

        repository.insertStats(ModelForDB(id = id,player = "bob",score = id))
    }
}