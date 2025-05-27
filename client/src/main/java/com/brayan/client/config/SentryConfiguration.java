package com.brayan.client.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.spring.jakarta.EnableSentry;


@EnableSentry(dsn = "https://30c2fe0f384191d5176813777e0a66e5@o4508429523681280.ingest.us.sentry.io/4508496212393984")
@Configuration
public class SentryConfiguration {
    
}
