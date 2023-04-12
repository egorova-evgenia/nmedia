package ru.netology.nmedia.service

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.repository.findByIdOrNull
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.entity.PostEntity
import ru.netology.nmedia.exception.NotFoundException
import ru.netology.nmedia.repository.PostRepository
import java.time.LocalDateTime
import java.time.OffsetDateTime

@Service
@Transactional
class PostService(private val repository: PostRepository) {

    val newPostId=0

    fun getAll(): List<Post> = repository
        .findAll(Sort.by(Sort.Direction.DESC, "id"))
        .map { it.toDto()}
        .apply {
            println("get all")
            println(this)
        }

    fun getById(id: Int): Post = repository
        .findById(id)
        .map { it.toDto() }
        .orElseThrow(::NotFoundException)
        .apply {
            println("i'm here")
            println(this)
        }

    fun save(dto: Post): Post = repository
        .findById(dto.id)
        .orElse(
            PostEntity.fromDto(
                dto.copy(
                    likes = 0,
                    iLiked = false
//                    published = OffsetDateTime.now().toEpochSecond()
                )
            )
        )
        .let {
            if (it.id == newPostId) repository.save(it) else it.content = dto.content
            it
        }.toDto()

    fun removeById(id: Int) {
        repository.findByIdOrNull(id)
            ?.also(repository::delete)
    }

    fun likeById(id: Int): Post = repository
        .findById(id)
        .orElseThrow(::NotFoundException)
        .apply {
            likes += 1
            iLiked = true
            println("like")
            println(iLiked)
            println(likes)

        }
        .toDto()

    fun unlikeById(id: Int): Post = repository
        .findById(id)
        .orElseThrow(::NotFoundException)
        .apply {
            likes -= 1
            iLiked = false
            println("dislike")
            println(iLiked)
            println(likes)

        }
        .toDto()
}