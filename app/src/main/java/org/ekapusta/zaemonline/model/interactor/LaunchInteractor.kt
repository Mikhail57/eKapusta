package org.ekapusta.zaemonline.model.interactor

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import org.ekapusta.zaemonline.Screens
import javax.inject.Inject

class LaunchInteractor @Inject constructor(
    @ApplicationContext private val context: Context,
    private val router: Router,
    private val dataInteractor: DataInteractor
) {
    private val dataStore: DataStore<Preferences> = context.createDataStore(
        name = "settings"
    )

    suspend fun isFirstLaunch(): Boolean {
        return dataStore.data.map { it[FIRST_PIN_LAUNCH] ?: true }.first()
    }

    suspend fun onLaunched() {
        val isFirstLaunch = isFirstLaunch()
        router.newRootScreen(Screens.SplashScreen())
        val data = dataInteractor.getData()
        if ((data.pin ?: 0.0) > PIN_THRESHOLD) {

        }
    }

    private fun writeFirstLaunch() {

    }

    companion object {
        private val FIRST_PIN_LAUNCH = preferencesKey<Boolean>("first_launch")
        private const val PIN_THRESHOLD = 100000
    }
}