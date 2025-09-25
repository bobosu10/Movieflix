package com.movieflix.movieflix.Response;

import lombok.Builder;

@Builder
public record StreamingResponse(String name,Long id) {
}
