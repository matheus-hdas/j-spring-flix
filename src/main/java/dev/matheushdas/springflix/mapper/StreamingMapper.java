package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.StreamingDTO;
import dev.matheushdas.springflix.entity.Streaming;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Streaming toEntity(StreamingDTO data) {
        return modelMapper.map(data, Streaming.class);
    }

    public StreamingDTO toDto(Streaming data) {
        return modelMapper.map(data, StreamingDTO.class);
    }
}
