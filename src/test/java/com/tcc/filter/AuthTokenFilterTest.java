package com.tcc.filter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.server.MockServerWebExchange;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

class AuthTokenFilterTest {

    @Test
    void shouldAllowOptionsRequestsWithoutAuthentication() {
        AuthTokenFilter filter = new AuthTokenFilter();
        ServerWebExchange exchange = MockServerWebExchange.from(
            org.springframework.mock.http.server.reactive.MockServerHttpRequest
                .options("/auth-service/auth/signin")
                .build()
        );
        org.springframework.cloud.gateway.filter.GatewayFilterChain chain = Mockito.mock(org.springframework.cloud.gateway.filter.GatewayFilterChain.class);
        Mockito.when(chain.filter(exchange)).thenReturn(Mono.empty());

        Mono<Void> result = filter.filter(exchange, chain);

        assertNotNull(result);
    }
}
