package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Entity.Category;
import com.movieflix.movieflix.Mapper.CategoryMapper;
import com.movieflix.movieflix.Repository.CategoryRepository;
import com.movieflix.movieflix.Request.CategoryRequest;
import com.movieflix.movieflix.Response.CategoryResponse;
import com.movieflix.movieflix.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CategoryResponse>> ListCategory(){
        return ResponseEntity.ok(categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList());
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody CategoryRequest request){
        Category category = CategoryMapper.toCategory(request);
        Category saveCategory = categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoryMapper.toCategoryResponse(saveCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> searchById(@PathVariable Long id){
        return categoryService.searchById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }




}
