package com.esprit.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder build){
        return build.routes()
                .route("cours",r->r.path("/cours/**")
                        .uri("http://localhost:8085"))
                .route("level",r->r.path("/level/**")
                        .uri("http://localhost:8082"))
                .route("subject",r->r.path("/subject/**")
                        .uri("http://localhost:8082"))
                .route("evaluations",r->r.path("/evaluations/**")
                        .uri("http://localhost:8081"))
                .route("professors",r->r.path("/professors/**")
                        .uri("http://localhost:8081"))
                .route("api/assignments",r->r.path("/api/assignments/**")
                        .uri("http://localhost:8084"))
                .route("students",r->r.path("/students/**")
                        .uri("http://localhost:8084"))
                .route("session",r->r.path("/session/**")
                        .uri("http://localhost:8083"))
                .build();
    }
}
