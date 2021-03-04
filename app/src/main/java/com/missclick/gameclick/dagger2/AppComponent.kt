package com.missclick.gameclick.dagger2

import com.missclick.gameclick.ui.launch.LaunchViewModel
import com.missclick.gameclick.ui.lost.LostViewModel
import com.missclick.gameclick.ui.main.MainViewModel
import com.missclick.gameclick.ui.win.LoseViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton

interface AppComponent {
    fun injection(a : LaunchViewModel)
    fun inject(launchViewModel: LaunchViewModel)
    fun inject(launefsechViewModel: MainViewModel)
    fun inject(lauseffnchViewModel: LostViewModel)
    fun inject(launchVsaefaiewModel: LoseViewModel)
}