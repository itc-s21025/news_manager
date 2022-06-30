package jp.ac.it_college.std.s21025.news_manager.presentation.controller

import jp.ac.it_college.std.s21025.news_manager.application.service.NewsService
import jp.ac.it_college.std.s21025.news_manager.presentation.form.GetNewsDetailResponse

import jp.ac.it_college.std.s21025.news_manager.presentation.form.GetNewsListResponse
import jp.ac.it_college.std.s21025.news_manager.presentation.form.NewsInfo
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("news")
@CrossOrigin(origins = ["http://localhost:8080/"], allowCredentials = "true")
class NewsController (
    private val newsService: NewsService
    ) {
    @GetMapping("/list")
    fun getList(): GetNewsListResponse {
        val newsList = newsService.getList().map {
            NewsInfo(it)
        }
        return GetNewsListResponse(newsList)
    }

    @GetMapping("/detail/{news_id}")
    fun getDetail(@PathVariable("news_id") newsId: Long): GetNewsDetailResponse {
        val news = newsService.getDetail(newsId)
        return GetNewsDetailResponse(news)
    }
}

