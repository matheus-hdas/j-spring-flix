package dev.matheushdas.springflix.controller;

import dev.matheushdas.springflix.dto.StreamingDTO;
import dev.matheushdas.springflix.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    @Autowired
    private StreamingService service;

    @GetMapping("/all")
    public ResponseEntity<List<StreamingDTO>> getAllStreamings() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingDTO> getStreamingById(@PathVariable Long id) {
        StreamingDTO streaming = service.findById(id);
        return streaming == null ?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(streaming);
    }

    @PostMapping("/save")
    public ResponseEntity<StreamingDTO> saveStreaming(@RequestBody StreamingDTO streaming) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(streaming));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStreaming(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
