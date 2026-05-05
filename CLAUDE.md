# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

```bash
# Build all modules from root
mvn clean package

# Build a single module
mvn clean package -pl product-service

# Run a specific service
mvn spring-boot:run -pl eureka-server
mvn spring-boot:run -pl product-service
mvn spring-boot:run -pl monitoring-service
mvn spring-boot:run -pl notification-service

# Run all tests
mvn test

# Run tests for a single module
mvn test -pl product-service
```

## Startup Order

Services must be started in this order:
1. `eureka-server` (port 8761) — must be running before any client service
2. `product-service` (port 8081)
3. `monitoring-service` (port 8082)
4. `notification-service` (port 8083)

## Architecture

This is a Spring Boot multi-module Maven project (`dropsight-core`) using Spring Cloud Netflix for service discovery.

- **Root `pom.xml`** — parent for all modules. Declares Spring Boot `3.2.0` and Spring Cloud `2023.0.0`. All child modules inherit from this parent — do not add a separate `<parent>` in child POMs.
- **eureka-server** — Service registry (`@EnableEurekaServer`). All other services register here via `defaultZone: http://localhost:8761/eureka/`.
- **product-service** — Only service with business logic and persistence. Uses JPA + H2 in-memory database. H2 console available at `http://localhost:8081/h2-console`. REST API at `/api/products`.
- **monitoring-service / notification-service** — Eureka clients with actuator endpoints exposed (`/actuator/health`, `/actuator/info`). Business logic not yet implemented.

## Module Conventions

- All Eureka client services use `@EnableDiscoveryClient` on their main application class.
- All services use `spring-boot-starter-web` (not `spring-boot-starter-webmvc`).
- Test dependency is `spring-boot-starter-test` (not `*-actuator-test` or `*-webmvc-test`).
- Lombok is used across all services — annotate entities/models with `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`; use `@RequiredArgsConstructor` for constructor injection in services and controllers.

## product-service Layer Structure

```
controller/   → REST layer (@RestController)
service/      → interface
service/impl/ → implementation (@Service)
repository/   → Spring Data JPA (@Repository)
model/        → JPA entities (@Entity)
```
