package jp.ac.it_college.std.s21025.news_manager.presentation.form

import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord
import java.time.LocalDate
import java.util.*

data class GetNewsListResponse(val newsList: List<NewsInfo>)

data class NewsInfo (
    val id: Long,
    val title: String,
    val body: String,
    val createAt: Date,
) {
    constructor(model: NewsWithCategoryRecord) : this(
        model.news.id, model.news.title, model.news.body, model.news.publishAt
    )
}
data class GetNewsDetailResponse(
    val id: Long,
    val title: String,
    val body: String,
    val createAt: Date,
    val CategoryInfo: CategoryInfo?,
) {
    constructor(model: NewsWithCategoryRecord) : this(
        model.news.id,
        model.news.title,
        model.news.body,
        model.news.publishAt,
        model.category?.let {CategoryInfo(model.category)}
    )
}

data class CategoryInfo(
    val id: Long,
    val name: String
) {
    constructor(rental: Category) : this(
        rental.id,
        rental.name

    )

}

data class RegisterNewsRequest(
    val id: Long,
    val title: String,
    val categoryId: String,
    val publishAt: Date,

)

data class UpdateNewsRequest(
    val id: Long,
    val title: String?,
    val body: String,
    val createAt: Date
)

