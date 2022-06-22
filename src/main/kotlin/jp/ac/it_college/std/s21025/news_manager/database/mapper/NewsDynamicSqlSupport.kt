/*
 * Auto-generated file. Created by MyBatis Generator
 */
package jp.ac.it_college.std.s21025.news_manager.database.mapper

import java.sql.JDBCType
import java.util.Date
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object NewsDynamicSqlSupport {
    val news = News()

    val id = news.id

    val title = news.title

    val categoryId = news.categoryId

    val publishAt = news.publishAt

    val createAt = news.createAt

    val userId = news.userId

    val body = news.body

    class News : AliasableSqlTable<News>("news", ::News) {
        val id = column<Long>(name = "id", jdbcType = JDBCType.BIGINT)

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR)

        val categoryId = column<Long>(name = "category_id", jdbcType = JDBCType.BIGINT)

        val publishAt = column<Date>(name = "publish_at", jdbcType = JDBCType.TIMESTAMP)

        val createAt = column<Date>(name = "create_at", jdbcType = JDBCType.TIMESTAMP)

        val userId = column<Long>(name = "user_id", jdbcType = JDBCType.BIGINT)

        val body = column<String>(name = "body", jdbcType = JDBCType.LONGVARCHAR)
    }
}