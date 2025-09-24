package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Entity.Category;
import com.movieflix.movieflix.Repository.CategoryRepository;
import com.movieflix.movieflix.Service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/movieflix/category")
public class CategoryController {

    private  CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> ListCategory(){
        return categoryService.findAll();
    }

    @PostMapping("/save")
    public Category saveCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }




}
