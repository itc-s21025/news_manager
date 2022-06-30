package jp.ac.it_college.std.s21025.news_manager.application.service

import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.domain.repository.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminCategoryService (
    private val categoryRepository: CategoryRepository
){
    @Transactional
    fun register(category: Category) {
        categoryRepository.register(category)
    }

    @Transactional
    fun update(category: Category) {
        categoryRepository.update(category.id, category.name)
    }

    @Transactional
    fun delete(categoryId: Long) {
        categoryRepository.delete(categoryId)
    }
}