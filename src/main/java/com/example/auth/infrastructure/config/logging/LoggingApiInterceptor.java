package com.example.auth.infrastructure.config.logging;

import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingApiInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingApiInterceptor.class);

    @Value("${logging.debug.enabled}")
    private boolean isDebugEnabled;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        logger.info("API Call - {} {} from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (isDebugEnabled && request instanceof ContentCachingRequestWrapper wrapper && request.getMethod().equalsIgnoreCase("POST")) {
            byte[] buf = wrapper.getContentAsByteArray();
            if (buf.length > 0) {
                String payload = new String(buf, StandardCharsets.UTF_8);
                logger.debug("Payload ({} {}): {} from {}", request.getMethod(), request.getRequestURI(), payload, request.getRemoteAddr());
            } else {
                logger.debug("Payload ({} {}): empty from {}", request.getMethod(), request.getRequestURI(), request.getRemoteAddr());
            }
        }
    }
}

