package jp.ac.it_college.std.s21025.news_manager.presentation.form

import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord
import java.time.LocalDateTime
import java.util.*

data class GetNewsListResponse(val newsList: List<NewsInfo>)

data class NewsInfo(
    val id: Long?,
    val title: String?,
    val categoryId: Long?,
    val publishAt: LocalDateTime?,
    val createAt: LocalDateTime?,
    val userId: Long?,
    val body: String?,
){
    constructor(model: NewsWithCategoryRecord) : this(
        model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body
    )
}

data class GetNewsDetailResponse(
    val id: Long?,
    val title: String?,
    val categoryId: Long?,
    val publishAt: LocalDateTime?,
    val createAt: LocalDateTime?,
    val userId: Long?,
    val body: String?,
) {
    constructor(model: NewsWithCategoryRecord) : this(
        model.id,
        model.title,
        model.categoryId,
        model.publishAt,
        model.createAt,
        model.userId,
        model.body,
    )
}

data class CategoryInfo(
    val id: Long,
    val name: String,
) {
    constructor(category: Category) : this(
        category.id,
        category.name
    )
}

data class RegisterNewsRequest(
    val title: String,
    val categoryId: Long,
    val publishAt: LocalDateTime,
    val body: String,
)

data class RegisterCategoryRequest(
    val name: String
)

data class UpdateCategoryRequest(
    val id: Long,
    val name: String
)