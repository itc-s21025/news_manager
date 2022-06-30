package jp.ac.it_college.std.s21025.news_manager.application.service

import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord
import jp.ac.it_college.std.s21025.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service

@Service
class NewsService (
    private val newsRepository: NewsRepository
) {
    fun getList(): List<NewsWithCategoryRecord> {
        return newsRepository.findAllWihCategory()
    }

    fun getDetail(newsId: Long): NewsWithCategoryRecord {
        return newsRepository.findWithCategory(newsId) ?: throw IllegalArgumentException("存在しないID: $newsId")
    }
}

