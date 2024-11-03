package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.StreamingDTO;
import dev.matheushdas.springflix.entity.Streaming;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {
    @Autowired
    private ModelMapper mapper;

    public Streaming toEntity(StreamingDTO data) {
        return mapper.map(data, Streaming.class);
    }

    public StreamingDTO toDto(Streaming data) {
        return mapper.map(data, StreamingDTO.class);
    }
}
