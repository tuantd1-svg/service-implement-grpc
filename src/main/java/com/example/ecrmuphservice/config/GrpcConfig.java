//package com.example.ecrmuphservice.config;
//
//import io.grpc.ClientInterceptor;
//import io.grpc.ServerInterceptor;
//import org.springframework.cloud.sleuth.Tracer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GrpcConfig {
//    @Bean
//    public ServerInterceptor serverInterceptor(Tracer tracer) {
//        return new ServerTracingInterceptor(tracer);
//    }
//
//    @Bean
//    public ClientInterceptor clientInterceptor(Tracer tracer) {
//        return new ClientTracingInterceptor(tracer);
//    }
//}