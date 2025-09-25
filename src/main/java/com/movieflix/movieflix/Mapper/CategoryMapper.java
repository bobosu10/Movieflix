package com.movieflix.movieflix.Mapper;

import com.movieflix.movieflix.Entity.Category;
import com.movieflix.movieflix.Request.CategoryRequest;
import com.movieflix.movieflix.Response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
