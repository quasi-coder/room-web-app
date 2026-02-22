# Room Web App

A Spring Boot web application for managing hotel rooms, featuring a JPA-backed REST API, Thymeleaf MVC views, Spring Security login, and both JSON and XML response formats.

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| Spring Boot | Application framework |
| Spring Web MVC | MVC controllers + Thymeleaf views |
| Spring Data JPA | Room persistence (CrudRepository) |
| Spring Security | Login page + endpoint protection |
| H2 / JPA | In-memory or configured database |
| Maven Wrapper | Build tool |

---

## Project Structure

```
room-web-app/
└── src/main/java/com/dwiveddi/boot/
    ├── RoomWebAppApplication.java    # Spring Boot entry point
    ├── Room.java                     # JPA entity (ROOM table: id, name, number, info)
    ├── RoomRepository.java           # CrudRepository<Room, Long>
    ├── RoomServices.java             # Service layer
    ├── RoomController.java           # MVC controller: GET /rooms → Thymeleaf view
    ├── ApiController.java            # REST controller: GET /api/rooms → JSON/XML
    ├── AdminController.java          # GET /login → login page
    └── SecurityConfiguration.java   # Spring Security config (in-memory auth)
└── src/main/resources/
    └── application.properties        # JPA config
```

---

## Features

- **REST API** — `GET /api/rooms` returns rooms as JSON or XML
- **MVC View** — `GET /rooms` renders a Thymeleaf page listing all rooms
- **Spring Security** — Login page at `/login`; public access to `/` and `/api/*`; all other routes require authentication
- **In-memory auth** — Credentials configured via `configureGlobal()`
- **JPA persistence** — Room entity mapped to `ROOM` table with columns `ROOM_ID`, `NAME`, `ROOM_NUMBER`, `BED_INFO`

---

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| GET | `/api/rooms` | List all rooms (JSON or XML) |
| GET | `/rooms` | MVC view of all rooms |
| GET | `/login` | Login page |

---

## Getting Started

1. **Run the application**
   ```bash
   ./mvnw clean spring-boot:run
   ```

2. **Access rooms as JSON**
   ```bash
   curl http://localhost:8080/api/rooms
   ```

3. **Access rooms as XML**
   ```bash
   curl -i -H "Accept:application/xml" http://localhost:8080/api/rooms
   ```

4. **Access MVC view**
   ```
   http://localhost:8080/rooms
   ```

**Works together with:** `room-clr-app` (fetches rooms to publish to queue) and `room-cleaner-consumer` (processes queue messages)
