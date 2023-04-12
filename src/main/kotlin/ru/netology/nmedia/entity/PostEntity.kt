package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Post
import java.time.LocalDateTime
import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Int,
//    val id: Int,
    val autor: String,
    val autorAvatar: String,
    val published: String,
    var content: String,
    val url: String,
    var likes: Int,
    var shares: Int,
    var viewes: Int,
    var iLiked: Boolean
//    var author: String,
//    var content: String,
//    var published: Long,
//    var likedByMe: Boolean,
//    var likes: Int = 0,
) {
    fun toDto() = Post(id, autor, autorAvatar, published,content, url, likes, shares, viewes, iLiked)

    companion object {
        fun fromDto(dto: Post) = PostEntity(dto.id, dto.autor, dto.autorAvatar, dto.published,dto.content, dto.url, dto.likes, dto.shares, dto.viewes, dto.iLiked)
    }
//    fun toDto() = Post(id, author, content, published, likedByMe, likes)
//
//    companion object {
//        fun fromDto(dto: Post) = PostEntity(dto.id, dto.author, dto.content, dto.published, dto.likedByMe, dto.likes)
//    }
}