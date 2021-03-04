package com.missclick.gameclick.ui.lost

import androidx.lifecycle.ViewModel
import com.missclick.gameclick.App
import com.missclick.gameclick.clickRepository.ClickIRepository
import javax.inject.Inject

class LostViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    @Inject
    lateinit var repository: ClickIRepository

    init {
        App.appComponent.inject(this)
    }
}