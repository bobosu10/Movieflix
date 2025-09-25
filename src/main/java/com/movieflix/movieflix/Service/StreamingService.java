package com.movieflix.movieflix.Service;

import com.movieflix.movieflix.Entity.Streaming;
import com.movieflix.movieflix.Mapper.StreamingMapper;
import com.movieflix.movieflix.Repository.StreamingRepository;
import com.movieflix.movieflix.Response.StreamingResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    private final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> listAllStreaming() {
        return streamingRepository.findAll();
    }

    public Streaming addStreaming(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public Optional<Streaming> searchById(Long id){
        return streamingRepository.findById(id);
    }

    public void deleteById(Long id){
        Optional<Streaming> exist = streamingRepository.findById(id);
        if (exist.isPresent()){
            streamingRepository.deleteById(id);
        }
    }
}
