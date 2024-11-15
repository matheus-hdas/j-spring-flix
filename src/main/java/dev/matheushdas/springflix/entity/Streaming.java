package dev.matheushdas.springflix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_streaming")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Streaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Streaming(String name) {
        this.name = name;
    }
}
