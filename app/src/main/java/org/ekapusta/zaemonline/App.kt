package org.ekapusta.zaemonline

import android.app.Application
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica

import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initYandex()
        initMyTracker()
    }

    private fun initYandex() {
        val config = YandexMetricaConfig.newConfigBuilder(YANDEX_SDK_KEY).build()
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
    }

    private fun initMyTracker() {
//        val trackerParams = MyTracker.getTrackerParams()
//        val trackerConfig = MyTracker.getTrackerConfig()
        MyTracker.initTracker(MY_TRACKER_SDK_KEY, this)
    }

    companion object {
        const val YANDEX_SDK_KEY = "bf43b2df-58fd-42fb-a158-b03c65a2b1fc"
        const val MY_TRACKER_SDK_KEY = "42929781813976601581"
    }
}