package jp.ac.it_college.std.s21025.news_manager.domain.model

import java.time.LocalDateTime

data class News(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val userId: Long,
    val body: String,
)


