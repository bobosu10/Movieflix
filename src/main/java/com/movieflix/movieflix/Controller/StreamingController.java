package com.movieflix.movieflix.Controller;

import com.movieflix.movieflix.Entity.Streaming;
import com.movieflix.movieflix.Mapper.StreamingMapper;
import com.movieflix.movieflix.Request.StreamingRequest;
import com.movieflix.movieflix.Response.StreamingResponse;
import com.movieflix.movieflix.Service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movieflix/streaming")
public class StreamingController {

    private StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping()
    public ResponseEntity<List<StreamingResponse>> listStreaming(){
        return ResponseEntity.ok(streamingService.listAllStreaming()
                .stream()
                .map(StreamingMapper::toStreamingResponse)
                .toList());
    }

    @PostMapping("/save")
    public ResponseEntity<StreamingResponse> saveStreaming(@RequestBody StreamingRequest request){
        Streaming streaming = StreamingMapper.toStreaming(request);
        Streaming saveStreaming = streamingService.addStreaming(streaming);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StreamingMapper.toStreamingResponse(saveStreaming));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingResponse> searchById(@PathVariable Long id){
        return streamingService.searchById(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        streamingService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
