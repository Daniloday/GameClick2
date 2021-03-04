package com.missclick.gameclick.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.missclick.gameclick.App
import com.missclick.gameclick.clickRepository.ClickIRepository
import com.missclick.gameclick.data.ModelForDB
import javax.inject.Inject

class MainViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Кликай быстро на картинки!"
    }
    val text: LiveData<String> = _text

    @Inject
    lateinit var repository: ClickIRepository

    init {
        App.appComponent.inject(this)

    }

    fun report(id : Int){
        repository.appendStats(ModelForDB(id = id,player = "bob",score = id))
        repository.delStats(ModelForDB(id = id,player = "bob",score = id))
        repository.nounStat()
    }
}