package org.ekapusta.zaemonline.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck
import org.ekapusta.zaemonline.model.data.RemoteApi
import org.ekapusta.zaemonline.model.data.RemoteApiImpl

@InstallIn(ApplicationComponent::class)
@DisableInstallInCheck
@Module
interface ApiModule {
    @Binds
    fun bindApi(remoteApiImpl: RemoteApiImpl): RemoteApi
}