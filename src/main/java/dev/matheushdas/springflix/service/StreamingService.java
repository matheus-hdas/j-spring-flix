package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.StreamingDTO;
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

    public List<StreamingDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public StreamingDTO findById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    public StreamingDTO save(StreamingDTO streaming) {
        return mapper.toDto(
                repository.save(mapper.toEntity(streaming)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
