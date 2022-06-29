package jp.ac.it_college.std.s21025.news_manager.database.repository

import jp.ac.it_college.std.s21025.news_manager.database.mapper.*
import jp.ac.it_college.std.s21025.news_manager.database.record.News as RecordNews
import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord as NewsWithCategoryModel
import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Repository
import jp.ac.it_college.std.s21025.news_manager.database.mapper.insert


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
        return RecordNews(model.id, model.title, model.categoryId, model.body, model.publishAt, model.createAt, model.userId)
    }

    /**override fun update(
        id: Long,
        title: String?,
        categoryId: Long,
        publisherAt: LocalDateTime,
        createAt: LocalDateTime,
        userId: Long,
        body: String
    ) {
        newsMapper.updateByPrimaryKeySelective(RecordNews(id, title, categoryId, body, publisherAt,createAt, userId))
    }
    **/
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
            record.categoryId!!,
            record.userId!!
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


    /**
    private fun toRecord(model: news): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.publishAt)
    }

}

**/
/**  あとから追加するオーバーライド文

override fun register(news: News) {
    newsMapper.insert(toRecord(news))
}

override fun update(id: Long, title: String?, categoryId: Long?, publishAt: LocalDate?) {
    newsMapper.updateByPrimaryKeySelective(RecordNews(id, title, categoryId, publishAt))
}

override fun delete(id: Long) {
    newsMapper.deleteByPrimaryKey(id)
}

**/
