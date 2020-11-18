package org.ekapusta.zaemonline.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.ekapusta.zaemonline.system.analytics.Analytics
import org.ekapusta.zaemonline.system.analytics.FirebaseAnalyticsImpl

@InstallIn(ApplicationComponent::class)
@DisableInstallInCheck
@Module
interface AnalyticsModule {
    @Binds
    fun bindsAnalytics(impl: FirebaseAnalyticsImpl): Analytics
}