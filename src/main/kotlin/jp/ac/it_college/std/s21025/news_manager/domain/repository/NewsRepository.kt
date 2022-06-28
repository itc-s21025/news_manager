package jp.ac.it_college.std.s21025.news_manager.domain.repository

import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord

interface NewsRepository {
    fun findAllWithCategory(): List<NewsWithCategoryRecord>
}