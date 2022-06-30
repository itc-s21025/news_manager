package jp.ac.it_college.std.s21025.news_manager.domain.repository

import jp.ac.it_college.std.s21025.news_manager.domain.model.Category

interface CategoryRepository {
    fun register(category: Category)

    fun update(id: Long, name: String?)

    fun delete(id: Long)
}

