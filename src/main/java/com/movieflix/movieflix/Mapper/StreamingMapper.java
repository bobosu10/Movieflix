package com.movieflix.movieflix.Mapper;

import com.movieflix.movieflix.Entity.Streaming;
import com.movieflix.movieflix.Request.StreamingRequest;
import com.movieflix.movieflix.Response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .name(streaming.getName())
                .id(streaming.getId())
                .build();
    }
}
