package org.ekapusta.zaemonline.system.analytics

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import com.google.firebase.analytics.FirebaseAnalytics
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface Analytics {
    fun logEvent(name: String, args: Bundle)
    fun logPinOpenedEvent()
    fun logPinEnteredEvent()
}

class FirebaseAnalyticsImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : Analytics {
    private val analytics: FirebaseAnalytics by lazy { FirebaseAnalytics.getInstance(context) }

    override fun logEvent(name: String, args: Bundle) {
        analytics.logEvent(name, args)
    }

    override fun logPinOpenedEvent() {
        logEvent(PIN_ACCEPTED, bundleOf(FirebaseAnalytics.Param.VALUE to 0))
    }

    override fun logPinEnteredEvent() {
        logEvent(PIN_ACCEPTED, bundleOf(FirebaseAnalytics.Param.VALUE to 1))
    }

    companion object {
        private const val PIN_ACCEPTED = "pin_accepted"
    }
}