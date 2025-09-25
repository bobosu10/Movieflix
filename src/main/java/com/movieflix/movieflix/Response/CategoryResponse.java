package com.movieflix.movieflix.Response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
