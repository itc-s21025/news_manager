package jp.ac.it_college.std.s21025.news_manager.domain.model

import java.time.LocalDate
import java.util.*

data class News(
    val id: Long,
    val title: String,
    val categoryId: Long,
    val publishAt: Date,
    val createAt: Date,
    val body: String,
    val name: String
)


