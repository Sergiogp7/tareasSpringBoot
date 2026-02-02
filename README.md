# CRUD MVC con Thymeleaf — RA3

## 1) Datos del alumno/a
- Entidad elegida Producto

## 2) Repositorio (fork) y gestión de versiones
- Repositorio base: https://github.com/profeInformatica101/tareasSpringBoot
- Enlace a MI fork: [(https://github.com/Sergiogp7/tareasSpringBoot/edit/main/README.md)]
- Nº de commits realizados: (mínimo 5)

## 3) Arquitectura
Explica brevemente cómo has organizado:
- Controller: ProductoController
- Service: ProductoService
- Repository: ProductoRepository
- Entity: Producto

## 4) Base de datos elegida (marca una)
- [X] H2
- [ ] MySQL
- [ ] PostgreSQL

## 5) Configuración de la base de datos
### 5.1 Dependencias añadidas
         <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>
        

### 5.2 application.properties / application.yml
spring.application.name=ProyectoSpring
server.port=9093

spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.hibernate.ddl-auto=create-drop

### 5.3 Pasos para crear la BD (si aplica)

## 6) Cómo ejecutar el proyecto
1. Requisitos (Java versión, Maven/Gradle, DB instalada si aplica)
2. Comando de arranque:
   - ./mvnw spring-boot:run
3. URL de acceso:
   - http://localhost:9095/...

## 7) Pantallas / Rutas MVC
- GET /entidad (listar)
- GET /entidad/nuevo (formulario alta)
- POST /entidad (crear)
- GET /entidad/{id}/editar (editar)
- POST /entidad/{id} (actualizar)
- POST /entidad/{id}/borrar (eliminar)


## 8) Mejoras extra (opcional)
- Validaciones
- Estilos Bootstrap
- Búsqueda
- Pruebas
- Paginación
