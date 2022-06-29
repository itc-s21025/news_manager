package jp.ac.it_college.std.s21025.news_manager.presentation.controller

import jp.ac.it_college.std.s21025.news_manager.application.service.AdminNewsService
import jp.ac.it_college.std.s21025.news_manager.domain.model.News
import jp.ac.it_college.std.s21025.news_manager.presentation.form.RegisterNewsRequest
import jp.ac.it_college.std.s21025.news_manager.presentation.form.UpdateNewsRequest
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime


@RestController
@RequestMapping("admin/news")
@CrossOrigin(origins = ["http://localhost:8081/"], allowCredentials = "true")
class AdminNewsController(
    private val adminNewsService: AdminNewsService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterNewsRequest) {
        adminNewsService.register(
           // News(request.id, request.title, request.body, request.createAt)
            News(
                0,
                request.title,
                request.categoryId,
                request.publishAt,
                LocalDateTime.now(),
                1,
            )
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateNewsRequest) {
        with(request) {
            adminNewsService.update(id, title, body, createAt)
        }
    }

    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long) {
        adminNewsService.delete(id)
    }
}