
# app-apigateway-api

API Gateway para orquestación y control de acceso a los microservicios del ecosistema TCC.

## Características principales
- Arquitectura Spring Boot + Spring Cloud Gateway.
- Filtro global para autenticación y autorización de solicitudes.
- Configuración centralizada de rutas y reglas en `application.yml`.
- Soporte CORS y seguridad reactiva con WebFlux.
- Logging centralizado y trazabilidad de solicitudes.
- Integración con Swagger para documentación de endpoints expuestos por el gateway.
- Pruebas unitarias para filtros y lógica de enrutamiento.

## Estructura del proyecto
- `src/main/java/com/tcc/api`: Controladores expuestos por el gateway (si aplica).
- `src/main/java/com/tcc/filter`: Filtros globales y de seguridad (ej. `AuthTokenFilter`).
- `src/main/java/com/tcc/conf`: Configuraciones de seguridad, CORS, Swagger, etc.
- `src/main/java/com/tcc/dto`: Modelos de datos para transferencia entre servicios.
- `src/main/java/com/tcc/enums`: Enumeraciones de estados, errores y tipos de origen.
- `src/main/java/com/tcc/exceptions`: Manejo centralizado de errores y excepciones.
- `src/main/resources/application.yml`: Configuración principal de rutas, CORS y microservicios.

## Ejecución
Requiere Java 21 y Maven.

```bash
mvn clean install
mvn spring-boot:run
```

## Pruebas
Las pruebas unitarias se encuentran en `src/test/java/com/tcc/filter` y cubren la lógica de autenticación y enrutamiento.

## Reglas de codificación y arquitectura
Consultar `/docs/reglas-arquitectura-y-codificacion.md` para detalles sobre buenas prácticas y convenciones obligatorias.
