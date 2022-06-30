package jp.ac.it_college.std.s21025.news_manager.database.record

import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date


data class NewsWithCategory(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null,
)
