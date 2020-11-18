package org.ekapusta.zaemonline.model.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    @SerialName("pin")
    val pin: Double?,

    @SerialName("name_3")
    val name: String,

    @SerialName("promocodes")
    val promocodes: List<Promocode>,

    @SerialName("chat")
    val chat: String?,

    @SerialName("articles")
    val articles: List<Article>
)

@Serializable
data class Promocode(
    @SerialName("promo_title")
    val title: String,

    @SerialName("promo_picture")
    val picture: String,

    @SerialName("promo_text")
    val text: String,

    @SerialName("promo_link")
    val link: String?
)

@Serializable
data class Article(
    @SerialName("article_pic")
    val picture: String,

    @SerialName("article_title")
    val title: String,

    @SerialName("article_text")
    val text: String
)