package jp.ac.it_college.std.s21025.news_manager.database.mapper

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
import jp.ac.it_college.std.s21025.news_manager.database.record.NewsWithCategory
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.select

@Mapper
interface NewsWithCategoryMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "NewsWithCategoryResult", value = [
            Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR ),
            Result(column = "category_Id", property = "categoryId", jdbcType = JdbcType.BIGINT ),
            Result(column = "publish_At", property = "publishAt", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "create_At", property = "create_At", jdbcType = JdbcType.TIMESTAMP),
            Result(column = "user_Id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "body", property = "body", jdbcType = JdbcType.VARCHAR),
            Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),

        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<NewsWithCategory>


    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("NewsWithCategoryResult")
    fun selectOne(selectStatement: SelectStatementProvider): NewsWithCategory?
}

private val columnList = listOf(id, title, categoryId, publishAt, createAt, userId, body, name)

fun NewsWithCategoryMapper.select(completer: SelectCompleter): List<NewsWithCategory> =
    select(columnList) {
        from(news, "b")
        leftJoin(category) {
            on(news.id) equalTo category.id
        }
        completer()
    }.run(this::selectMany)

fun NewsWithCategoryMapper.selectByPrimaryKey(id_: Long, completer: SelectCompleter): NewsWithCategory? =
    select(columnList) {
        from(news, "b")
        leftJoin(category, "r") {
            on(news.id) equalTo category.id
        }
        where {
            id isEqualTo id_
        }
        completer()
    }.run(this::selectOne)



