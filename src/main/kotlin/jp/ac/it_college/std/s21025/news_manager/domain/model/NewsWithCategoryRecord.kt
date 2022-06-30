package jp.ac.it_college.std.s21025.news_manager.domain.model

import java.time.LocalDateTime


data class NewsWithCategoryRecord(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDateTime? = null,
    var createAt: LocalDateTime? = null,
    var userId: Long? = null,
    var body: String? = null,
)

