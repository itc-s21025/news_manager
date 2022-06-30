package jp.ac.it_college.std.s21025.news_manager.presentation.controller

import jp.ac.it_college.std.s21025.news_manager.application.service.AdminCategoryService
import jp.ac.it_college.std.s21025.news_manager.domain.model.Category
import jp.ac.it_college.std.s21025.news_manager.presentation.form.RegisterCategoryRequest
import jp.ac.it_college.std.s21025.news_manager.presentation.form.UpdateCategoryRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("admin/category")
@CrossOrigin(origins = ["http://localhost8080/"], allowCredentials = "true")
class CategoryController(
    private val adminCategoryService: AdminCategoryService
) {
    @PostMapping("/register")
    fun register(@RequestBody request: RegisterCategoryRequest) {
        adminCategoryService.register(
            Category(0, request.name)
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateCategoryRequest) {
        adminCategoryService.update(
            Category(request.id, request.name)
        )
    }

    @DeleteMapping("/delete/{category_id}")
    fun delete(@PathVariable("category_id") categoryId: Long) {
        adminCategoryService.delete(categoryId)
    }
}