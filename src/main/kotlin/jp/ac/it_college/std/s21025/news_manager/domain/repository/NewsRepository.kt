package jp.ac.it_college.std.s21025.news_manager.domain.repository


import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord


interface NewsRepository {
    fun findAllWihCategory(): List<NewsWithCategoryRecord>

    fun findWithCategory(id: Long): NewsWithCategoryRecord?

    fun register(news: News)

}


