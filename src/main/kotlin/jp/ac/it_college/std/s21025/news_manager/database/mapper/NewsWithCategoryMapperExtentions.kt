package jp.ac.it_college.std.s21025.news_manager.database.mapper

/**
import jp.ac.it_college.std.s21025.news_manager.database.mapper.CategoryDynamicSqlSupport.category
import jp.ac.it_college.std.s21025.news_manager.database.mapper.CategoryDynamicSqlSupport.id
import jp.ac.it_college.std.s21025.news_manager.database.mapper.CategoryDynamicSqlSupport.name
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.body
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.categoryId
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.createAt
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.news
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.publishAt
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.title
import jp.ac.it_college.std.s21025.news_manager.database.mapper.NewsDynamicSqlSupport.userId
import jp.ac.it_college.std.s21025.news_manager.database.record.News
import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

class NewsWithCategoryMapperExtentions {
    private val columnList = listOf(
        id,
        title,
        categoryId,
        publishAt,
        createAt,
        userId,
        body,
        name
    )

    fun NewsWithCategoryMapper.select(): List<NewsWithCategory> {
        val selectStatement = select(columnList).from(News, "b") {
            leftJoin(category, "r") {
                on(news.id, equals(category.id))
            }
        }
        return selectMany(selectStatement)
    }
}
**/