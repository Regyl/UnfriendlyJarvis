package com.github.regyl.unfriendlyjarvis.config.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * Global request interceptor for header Accept.
 * <p>
 * FIXME: A big crunch. Remove it
 */
@Component
public class AcceptContentTypeRequestInterceptor implements RequestInterceptor {
    
    @Override
    public void apply(RequestTemplate template) {
        template.header("Accept", "application/json");
    }
}
