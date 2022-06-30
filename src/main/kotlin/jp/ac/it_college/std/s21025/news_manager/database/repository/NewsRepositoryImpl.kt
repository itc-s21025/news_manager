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

/**
@Repository
class NewsRepositoryImpl (
    private val NewsWithCategoryMapper: NewsWithCategoryMapper,
            private val newsMapper: NewsMapper
) : NewsRepository {

    override fun findAllWithCategory(): List<NewsWithCategoryModel> {
        return NewsWithCategoryMapper.select { }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWithCategoryModel? {
        return NewsWithCategoryMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toRecord(news))
    }

    private fun toRecord(model: News): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.body, model.publishAt, model.createAt)
    }

    override fun update(id: Long, title: String?, categoryId: Long?, publishAt: LocalDateTime?, createAt: LocalDateTime?, userId: Long?, body: String? ) {
        newsMapper.updateByPrimaryKeySelective(RecordNews(id, title, categoryId, body, publishAt,createAt))
    }

    override fun delete(id: Long) {
        newsMapper.deleteByPrimaryKey(id)
    }

    private fun toModel(record: NewsWithCategory): NewsWithCategoryModel {
        val news = News(
            record.id!!,
            record.title!!,
            record.body!!,
            record.publishAt!!,
            record.createAt!!,
            record.categoryId!!
        )
        val category = record.id?.let {
            Category(
                record.id!!,
                record.name!!
            )
        }
        return NewsWithCategoryModel(news, category)
    }
}
**/


