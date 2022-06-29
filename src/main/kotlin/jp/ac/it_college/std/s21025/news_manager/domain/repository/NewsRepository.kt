package jp.ac.it_college.std.s21025.news_manager.domain.repository

import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord
import java.time.LocalDateTime
import java.util.*

interface NewsRepository {
    fun findAllWithCategory(): List<NewsWithCategoryRecord>

    fun findWithCategory(id: Long): NewsWithCategoryRecord?

    fun register(news: News)

    fun update(
        id: Long,
        title: String?,
        categoryId: Long?,
        publishAt: LocalDateTime?,
        createAt: LocalDateTime?,
        userId: Long?,
        body: String?
    )


    fun delete(id: Long)



}


