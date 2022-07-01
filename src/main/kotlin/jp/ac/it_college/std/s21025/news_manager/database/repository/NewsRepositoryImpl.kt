package jp.ac.it_college.std.s21025.news_manager.database.repository

import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.repository.NewsRepository
import jp.ac.it_college.std.s21025.news_manager.database.mapper.*
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord as ModelNewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.database.record.News as RecordNews

@Repository
class NewsRepositoryImpl(
    private val newsWithCategoryMapper: NewsWithCategoryMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWihCategory(): List<ModelNewsWithCategory> {
        return newsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): ModelNewsWithCategory? {
        return newsWithCategoryMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toCategory(news))
    }

    private fun toModel(record: NewsWithCategory): ModelNewsWithCategory {
        return ModelNewsWithCategory(record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.userId!!,
            record.body!!,)
    }

    private fun toCategory(model: News): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.publishAt, model.createAt, model.userId, model.body)
    }
}