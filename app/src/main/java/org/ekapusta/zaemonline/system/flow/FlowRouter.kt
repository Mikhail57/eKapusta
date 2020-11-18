package org.ekapusta.zaemonline.system.flow

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppScreen

class FlowRouter(private val appRouter: Router) : Router() {
    fun startFlow(screen: AppScreen) {
        appRouter.navigateTo(screen)
    }

    fun newRootFlow(screen: AppScreen) {
        appRouter.newRootScreen(screen)
    }

    fun finishFlow() {
        appRouter.exit()
    }
}