package jp.ac.it_college.std.s21025.news_manager.domain.model



data class NewsWithCategoryRecord(
    val news: News,
    val category: Category?
) {
    val isCategory: Boolean
        get() = category != null
}

