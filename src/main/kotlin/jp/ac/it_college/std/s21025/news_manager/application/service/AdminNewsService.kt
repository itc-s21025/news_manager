package jp.ac.it_college.std.s21025.news_manager.application.service

import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.domain.repository.NewsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*


@Service
class AdminNewsService (
        private val newsRepository: NewsRepository
    ) {
        @Transactional
        fun register(news: News) {
            newsRepository.findWithCategory(news.id)?.let {
                throw IllegalArgumentException("すでに存在するnewsID: ${news.id}")
            }
            newsRepository.register(news)
        }

        @Transactional
        fun update(id: Long, title: String?, categoryId: Long?, publishAt: LocalDateTime?, createAt: LocalDateTime?, userId: Long?, body: String?) {
            newsRepository.findWithCategory(id) ?: throw IllegalArgumentException("存在しないnewsID $id")
            newsRepository.update(id, title, categoryId, publishAt, createAt, userId, body)
        }

        @Transactional
        fun delete(id: Long) {
            newsRepository.findWithCategory(id) ?: throw IllegalArgumentException("存在しないnewsID: $id")
            newsRepository.delete(id)
        }
    }
