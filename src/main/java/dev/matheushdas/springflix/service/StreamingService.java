package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.CreateStreamingRequest;
import dev.matheushdas.springflix.dto.StreamingResponse;
import dev.matheushdas.springflix.mapper.StreamingMapper;
import dev.matheushdas.springflix.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository repository;

    @Autowired
    private StreamingMapper mapper;

    public List<StreamingResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public StreamingResponse findById(Long id) {
        return mapper.toResponse(repository.findById(id).orElseThrow());
    }

    public StreamingResponse save(CreateStreamingRequest streaming) {
        return mapper.toResponse(
                repository.save(mapper.toEntity(streaming)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
