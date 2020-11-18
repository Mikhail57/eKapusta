package org.ekapusta.zaemonline

import com.github.terrakok.cicerone.androidx.AppScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.ekapusta.zaemonline.ui.PinFragment

object Screens {
    class SplashScreen : FragmentScreen(
        fragmentCreator = {
            PinFragment()
        }
    )
}