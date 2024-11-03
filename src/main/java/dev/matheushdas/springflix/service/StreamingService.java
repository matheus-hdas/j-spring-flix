package dev.matheushdas.springflix.service;

import dev.matheushdas.springflix.dto.StreamingDTO;
import dev.matheushdas.springflix.mapper.StreamingMapper;
import dev.matheushdas.springflix.repository.StreamingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingService {

    @Autowired
    private StreamingRepository streamingRepository;

    @Autowired
    private StreamingMapper streamingMapper;

    public List<StreamingDTO> findAll() {
        return streamingRepository.findAll()
                .stream()
                .map(streamingMapper::toDto)
                .toList();
    }

    public StreamingDTO findById(Long id) {
        return streamingMapper.toDto(streamingRepository.findById(id).orElse(null));
    }

    public StreamingDTO save(StreamingDTO streaming) {
        return streamingMapper.toDto(
                streamingRepository.save(streamingMapper.toEntity(streaming)));
    }

    public void delete(Long id) {
        streamingRepository.deleteById(id);
    }
}
