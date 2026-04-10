# Movie Booking System

## Features
- View available seats
- Book seats with locking mechanism

## Tech Stack
- Spring Boot
- JPA (Hibernate)
- H2 Database

## APIs

### Get Seats
GET /shows/{showId}/seats

### Book Seats
POST /bookings/create

## Key Design Decisions
- Seat locking to prevent double booking
- Expiry-based locks
- Transactional booking flow

## Future Improvements
- Redis for distributed locking
- Kafka for event-driven booking
- Payment gateway integration