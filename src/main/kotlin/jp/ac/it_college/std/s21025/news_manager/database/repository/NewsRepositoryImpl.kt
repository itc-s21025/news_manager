package jp.ac.it_college.std.s21025.news_manager.database.repository

import jp.ac.it_college.std.s21025.news_manager.database.mapper.*
import jp.ac.it_college.std.s21025.news_manager.database.record.Category as RecordCategory
import jp.ac.it_college.std.s21025.news_manager.database.record.News as RecordNews
import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import jp.ac.it_college.std.s21025.news_manager.domain.model.NewsWithCategoryRecord as NewsWithCategoryModel
import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate



@Repository
class NewsRepositoryImpl (
    private val NewsWithCategoryMapper: NewsWithCategoryMapper,
            private val newsMapper: NewsMapper
) : NewsRepository {
    override fun findAllWithCategory(): List<NewsWithCategoryModel> {
        return NewsWithCategoryMapper.select {  }.map { toModel(it) }
    }

    override fun findWithCategory(id: Long): NewsWithCategoryModel? {
        return NewsWithCategoryMapper.selectByPrimaryKey(id) {
        }?.let { toModel(it) }
    }

    override fun register(news: News) {
        newsMapper.insert(toRecord(news))
    }

    override fun update(id: Long, title: String?, categoryId: Long?, publishAt: LocalDate?) {
        newsMapper.updateByPrimaryKeySelective(RecordNews(id, title, categoryId, publishAt))
    }

    override fun delete(id: Long) {
        newsMapper.deleteByPrimaryKey(id)
    }

    private fun toModel(record: NewsWithCategory): NewsWithCategoryModel {
        val news = News (
            record.id!!,
            record.title!!,
            record.categoryId!!,
            record.publishAt!!,
            record.createAt!!,
            record.body!!,
            record.name!!
        )
        val category = record.id?.let {
            Category(
                record.id!!,
                record.name!!
            )
        }
        return NewsWithCategoryModel(news, category)
    }

    private fun toRecord(model: news): RecordNews {
        return RecordNews(model.id, model.title, model.categoryId, model.publishAt)
    }

}


/**BookRepository {
    override fun findAllWithRental(): List<BookWithRental> {
        return bookWithRentalMapper.select {  }.map { toModel(it)}
    }

Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR ),
Result(column = "categoryId", property = "categoryId", jdbcType = JdbcType.BIGINT ),
Result(column = "publishAt", property = "", jdbcType = JdbcType.TIMESTAMP),
Result(column = "createAt", property = "", jdbcType = JdbcType.TIMESTAMP),
Result(column = "userId", property = "", jdbcType = JdbcType.BIGINT),
Result(column = "body", property = "", jdbcType = JdbcType.VARCHAR),
Result(column = "name", property = "", jdbcType = JdbcType.VARCHAR),
**/