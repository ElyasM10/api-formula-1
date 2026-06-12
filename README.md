# api-formula-1

API REST desarrollada con Quarkus para consultar datos de Fórmula 1: pilotos y equipos.

## Tecnologías

- Java 17
- Quarkus 3.21.2
- Hibernate ORM + Panache
- PostgreSQL
- MapStruct 1.5.2
- SmallRye OpenAPI (Swagger)
- Quarkus REST + Jackson

## Requisitos previos

- JDK 17+
- Maven 3.8+
- PostgreSQL corriendo en `localhost:5432` con base de datos `postgres`

## Configuración

`src/main/resources/application.properties`:

| Propiedad | Valor por defecto | Descripción |
|---|---|---|
| `quarkus.datasource.jdbc.url` | `jdbc:postgresql://localhost:5432/postgres` | URL de la base de datos |
| `quarkus.datasource.username` | `postgres` | Usuario de la base de datos |
| `quarkus.hibernate-orm.database.generation` | `none` | No modifica el esquema automáticamente |
| `quarkus.http.cors.origins` | `*` | CORS habilitado para todos los orígenes |

## Estructura del proyecto

```
src/main/java/org/elias/
├── recurso/
│   ├── RecursoPilotos.java      # REST resource — endpoints GET /pilotos
│   └── RecursoEquipos.java      # REST resource — endpoints GET /equipos
├── servicio/
│   ├── ServicioPilotos.java     # Lógica de negocio para pilotos
│   └── ServicioEquipos.java     # Lógica de negocio para equipos
├── acceso/
│   ├── AccesoPilotos.java       # Repositorio Panache para pilotos
│   └── AccesoEquipos.java       # Repositorio Panache para equipos
├── modelo/
│   ├── Pilotos.java             # Entidad JPA — tabla pilotos
│   └── Equipos.java             # Entidad JPA — tabla equipos (relación 1:N con pilotos)
├── transferible/
│   ├── TransferiblePilotos.java # DTO de respuesta para pilotos
│   └── TransferibleEquipos.java # DTO de respuesta para equipos
├── transformador/
│   ├── TransformadorPilotos.java # Mapper MapStruct entidad → DTO
│   └── TransformadorEquipos.java # Mapper MapStruct entidad → DTO
└── exception/
    ├── ExceptionMappers.java    # Mapper global de excepciones a respuestas HTTP
    └── Http*.java               # Excepciones HTTP tipadas (400, 403, 404, 409, 500, 204)
```

## Modelo de datos

**equipos**

| Campo | Tipo | Descripción |
|---|---|---|
| id | Long | Clave primaria |
| nombre | String | Nombre del equipo |
| pais | String | País de origen |
| jefe_equipo | String | Nombre del director |
| motor | String | Proveedor de motor |
| descripcion | String | Descripción del equipo |

**pilotos**

| Campo | Tipo | Descripción |
|---|---|---|
| id | Long | Clave primaria |
| nombre | String | Nombre del piloto |
| apellido | String | Apellido del piloto |
| nacionalidad | String | Nacionalidad |
| fecha_nacimiento | Date | Fecha de nacimiento |
| descripcion | String | Descripción del piloto |
| numero | Integer | Número de carrera |
| equipo_id | Long | FK → equipos |

## Endpoints

### Pilotos

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/pilotos` | Lista todos los pilotos |
| `GET` | `/pilotos/{id}` | Obtiene un piloto por ID |

### Equipos

| Método | Ruta | Descripción |
|---|---|---|
| `GET` | `/equipos` | Lista todos los equipos |
| `GET` | `/equipos/{id}` | Obtiene un equipo por ID |

## Ejecutar en modo desarrollo

```bash
./mvnw quarkus:dev
```

El servicio queda disponible en `http://localhost:8080`.

## Swagger UI

```
http://localhost:8080/q/swagger-ui
```

## Build para producción

```bash
# JVM
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar

# Nativo
./mvnw package -Pnative
./target/api-formula-1-1.0.0-SNAPSHOT-runner
```
