package com.microservice.apigateway.security;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GlobalFilter {
    @Autowired
    private JwtService jwt;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();

        if(request.getURI().getPath().contains("/auth")){
            return chain.filter(exchange);
        }

        if(!request.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
            throw new RuntimeException(("Missing Authorization Header"));
        }

        String authHeader = request.getHeaders().getFirst(org.springframework.http.HttpHeaders.AUTHORIZATION);

        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            throw new RuntimeException("Invalid Authorization Header");
        }

        String token = authHeader.substring(7);

        if(jwt.validateToken(token)){
            throw new RuntimeException("invalid token");
        }
        return chain.filter(exchange);
    }
}
