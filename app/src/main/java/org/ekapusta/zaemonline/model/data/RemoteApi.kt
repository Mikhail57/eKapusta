package org.ekapusta.zaemonline.model.data

import io.ktor.client.*
import io.ktor.client.request.*
import org.ekapusta.zaemonline.model.pojo.ApiResponse
import javax.inject.Inject

interface RemoteApi {
    suspend fun getData(): ApiResponse
}

class RemoteApiImpl @Inject constructor(
    private val client: HttpClient
) : RemoteApi {
    override suspend fun getData(): ApiResponse {
        return client.get(URL)
    }

    companion object {
        private const val URL = ""
    }
}