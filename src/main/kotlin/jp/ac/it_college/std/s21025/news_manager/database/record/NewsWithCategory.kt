package jp.ac.it_college.std.s21025.news_manager.database.record

import java.time.LocalDate


data class NewsWithCategory(
    var id: Long? = null,
    var title: String? = null,
    var categoryId: Long? = null,
    var publishAt: LocalDate? = null,
    var createAt: LocalDate? = null,
    var userId: Long? = null,
    var body: String? = null,
    var name: String? = null
)
