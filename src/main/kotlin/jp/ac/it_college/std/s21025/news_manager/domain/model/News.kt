package jp.ac.it_college.std.s21025.news_manager.domain.model

import java.time.LocalDateTime
import java.util.*

data class News(
    val id: Long,
    val title: String,
    val body: String,
    val publishAt: LocalDateTime,
    val createAt: LocalDateTime,
    val categoryId: Long,
    val userId: Long
)


