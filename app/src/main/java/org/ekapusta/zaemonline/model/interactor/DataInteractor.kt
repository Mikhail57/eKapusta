package org.ekapusta.zaemonline.model.interactor

import org.ekapusta.zaemonline.model.data.RemoteApi
import org.ekapusta.zaemonline.model.pojo.ApiResponse
import javax.inject.Inject

class DataInteractor @Inject constructor(
    private val api: RemoteApi
) {
    suspend fun getData(): ApiResponse  = api.getData()
}
