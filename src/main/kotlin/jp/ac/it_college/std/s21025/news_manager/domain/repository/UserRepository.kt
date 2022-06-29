package jp.ac.it_college.std.s21025.news_manager.domain.repository

import jp.ac.it_college.std.s21025.news_manager.domain.model.User

interface UserRepository {
    fun find(email: String): User?

    fun find(id: Long): User?
}