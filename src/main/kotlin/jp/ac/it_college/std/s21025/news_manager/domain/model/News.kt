package jp.ac.it_college.std.s21025.news_manager.domain.model

import java.time.LocalDate

data class News(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDate,
    val createAt: LocalDate,
    val body: String,
    val name: String
)


