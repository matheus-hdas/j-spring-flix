# SpringFlix

Spring-Flix is a backend API designed to manage a catalog of movies and their availability on various streaming platforms. Built with Spring Boot, this API allows users to add, update, delete, and search for movies, as well as view the streaming platforms where each movie is available.

## Features
- `CRUD Operations` for movies
- `Streaming Platforms` integration for each movie
- `RESTful API with clear` endpoints and standard responses
- `Swagger UI documentation` for easy API testing

## Technologies
- `Java 17`
- `Spring Boot 3`
- `Spring Data JPA` for data persistence
- `Spring Security` for authentication and authorization
- `Postgres` for database
- `Flyway` for migrations
- `Swagger` for API documentation

## Installation

### 1. Clone this repository
```bash
git clone https://github.com/yourusername/spring-flix.git
cd spring-flix
```
### 2. Run compose file
```bash
docker compose -f src/main/resources/compose.yaml up -d
```
### 3. Run application
```bash
mvn spring-boot:run
```
## API Endpoints
Below are some key API endpoints in Spring-Flix:
### 1. Movies
   - `POST /api/movie` - Add a new movie
   - `GET /api/movie/{id}` - Get a movie by ID
   - `PATCH /api/movie/{id}` - Update a movie
   - `DELETE /api/movie/{id}` - Delete a movie
### 2. Streaming
   - `POST /api/streaming` - Add a new platform
   - `GET /api/streaming` - Get all streaming plataforms
### 3. Category
   - `POST /api/category` - Add a new category
   - `GET /api/category/{id}` - Get a category by ID
   - `DELETE /api/category/{id}` - Delete a category

## Contributing

Contributions are welcome! Please fork this repository, make your changes, and submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.
