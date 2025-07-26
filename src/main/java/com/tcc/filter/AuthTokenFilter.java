package com.tcc.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthTokenFilter implements GlobalFilter, Ordered {
    private void addCorsHeaders(ServerWebExchange exchange) {
        exchange.getResponse().getHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponse().getHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponse().getHeaders().set("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");
        exchange.getResponse().getHeaders().set("Access-Control-Max-Age", "3600");
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();

        String originalUrl = exchange.getRequest().getURI().toString();
        System.out.println("Solicitud recibida: " + originalUrl);

   
        // Rutas públicas que no requieren token
        if (path.startsWith("/public") || path.startsWith("/health") || path.startsWith("/info") || path.startsWith("/auth-service")) {
             // Token válido, continuar y ejecutar lógica post filtro
            return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    // Lógica post filtro: aquí puedes acceder a atributos como la URL final
                    Object routedUrl = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
                    System.out.println("URL final hacia el backend: " + routedUrl);
                    // Puedes agregar más lógica aquí (logging, métricas, etc.)
                })
            );
        }

        // se debe retirar e implementar la lógica de validación del token
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    // Lógica post filtro: aquí puedes acceder a atributos como la URL final
                    Object routedUrl = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR);
                    System.out.println("URL final hacia el backend: " + routedUrl);
                    // Puedes agregar más lógica aquí (logging, métricas, etc.)
                })
            );

        // Obtener el token del header Authorization
        /*String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            addCorsHeaders(exchange);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7); // Quitar "Bearer "

        // Aquí validas el token como necesites
        if (!isTokenValid(token, path)) {
            addCorsHeaders(exchange);
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return exchange.getResponse().setComplete();
        }

        // Token válido, continuar
        return chain.filter(exchange);*/
    }

    private boolean isTokenValid(String token, String path) {
        // TODO: implementar tu lógica de validación (ej: JWT claims, scopes, etc.)
        // Aquí un ejemplo ficticio para ilustrar:
        return token.equals("abc123") && !path.contains("admin");
    }

    @Override
    public int getOrder() {
        return -1; // se ejecuta antes que otros filtros por defecto
    }
}
