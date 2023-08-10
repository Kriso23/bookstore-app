package dev.kristian.bookstoreapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "bks")
public record BookstoreProperties(
    String welcomeMessage, String aboutMessage
) {
    
}
