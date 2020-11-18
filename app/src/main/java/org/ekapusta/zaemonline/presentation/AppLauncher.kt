package org.ekapusta.zaemonline.presentation

import com.github.terrakok.cicerone.Router
import org.ekapusta.zaemonline.model.interactor.LaunchInteractor
import javax.inject.Inject

class AppLauncher @Inject constructor(
    private val launchInteractor: LaunchInteractor,
    private val router: Router
) {
    fun onLaunch() {
//        launchInteractor.
    }
}