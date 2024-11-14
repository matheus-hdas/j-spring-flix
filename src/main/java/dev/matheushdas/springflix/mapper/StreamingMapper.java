package dev.matheushdas.springflix.mapper;

import dev.matheushdas.springflix.dto.CreateStreamingRequest;
import dev.matheushdas.springflix.dto.StreamingResponse;
import dev.matheushdas.springflix.entity.Streaming;
import org.springframework.stereotype.Component;

@Component
public class StreamingMapper {

    public Streaming toEntity(CreateStreamingRequest data) {
        return new Streaming(
                data.name()
        );
    }

    public StreamingResponse toResponse(Streaming data) {
        return new StreamingResponse(
                data.getId(),
                data.getName()
        );
    }
}
