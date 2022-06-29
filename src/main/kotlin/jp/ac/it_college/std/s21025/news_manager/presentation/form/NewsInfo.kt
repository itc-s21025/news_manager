package jp.ac.it_college.std.s21025.news_manager.presentation.form

import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord
import java.time.LocalDate
import java.util.*

data class GetNewsListResponse(val newsList: List<NewsInfo>)

data class NewsInfo (
    val title: String,
    val categoryId: Long,
    val createAt: Date,
    val body: String
)

{
    constructor(model: NewsWithCategoryRecord) : this(
        model.news.title, model.news.categoryId, model.news.createAt, model.news.body
    )
}