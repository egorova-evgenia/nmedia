package ru.netology.nmedia.dto

import java.time.LocalDateTime

data class Post(
    val id: Int,
    val autor: String,
    val autorAvatar: String,
    val published: String,
    val content: String,
    val url: String,
    var likes: Int,
    var shares: Int,
    var viewes: Int,
    var iLiked: Boolean

//    val id: Long,
//    val author: String,
//    val content: String,
//    val published: Long,
//    val likedByMe: Boolean,
//    val likes: Int = 0,
)