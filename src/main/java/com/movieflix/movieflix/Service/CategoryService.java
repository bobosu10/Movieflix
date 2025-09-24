package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Entity.Category;
import com.movieflix.movieflix.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category addCategory(Category category){
        return repository.save(category);
    }
}


