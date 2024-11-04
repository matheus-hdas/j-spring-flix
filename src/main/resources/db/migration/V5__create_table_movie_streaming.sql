CREATE TABLE tb_movie_stream_service (
    movie_id INTEGER,
    service_id INTEGER,
    CONSTRAINT fk_movie_stream_service_movie FOREIGN KEY(movie_id) REFERENCES tb_movie(id),
    CONSTRAINT fk_movie_stream_service_stream_service FOREIGN KEY(service_id) REFERENCES tb_streaming(id)
);