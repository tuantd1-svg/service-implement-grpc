//package com.example.ecrmuphservice.config;
//
//import io.opentelemetry.api.OpenTelemetry;
//import io.opentelemetry.api.metrics.Meter;
//import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
//import io.opentelemetry.sdk.OpenTelemetrySdk;
//import io.opentelemetry.sdk.metrics.SdkMeterProvider;
//import io.opentelemetry.sdk.trace.SdkTracerProvider;
//import io.opentelemetry.sdk.trace.SpanProcessor;
//import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
//import org.springframework.cloud.sleuth.Tracer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import static io.opentelemetry.api.GlobalOpenTelemetry.getMeterProvider;
//import static io.opentelemetry.api.GlobalOpenTelemetry.getTracerProvider;
//
//@Configuration
//public class OpenTelemetryConfig {
//    @Bean
//    public Tracer tracer() {
//        return (Tracer) getTracerProvider().get("my-tracer");
//    }
//
//    @Bean
//    public Meter meter() {
//        return getMeterProvider().get("my-meter");
//    }
//
//    @Bean
//    public OtlpGrpcSpanExporter otlpGrpcSpanExporter() {
//        return OtlpGrpcSpanExporter.builder()
//                .setEndpoint("localhost:55680")
//                .build();
//    }
//
//    @Bean
//    public SpanProcessor spanProcessor(OtlpGrpcSpanExporter otlpGrpcSpanExporter) {
//        return BatchSpanProcessor.builder(otlpGrpcSpanExporter).build();
//    }
//
//    @Bean
//    public OpenTelemetrySdk openTelemetrySdk(SpanProcessor spanProcessor) {
//        SdkTracerProvider tracerProvider = SdkTracerProvider.builder()
//                .addSpanProcessor(spanProcessor)
//                .build();
//
//        SdkMeterProvider meterProvider = SdkMeterProvider.builder().build();
//
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .setMeterProvider(meterProvider)
//                .build();
//    }
//}