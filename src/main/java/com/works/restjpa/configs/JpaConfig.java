package com.works.restjpa.configs;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class JpaConfig implements AuditorAware<String> {

    final HttpServletRequest request;

    @Override
    public Optional<String> getCurrentAuditor() {
        String email = (String) request.getSession().getAttribute("user");
        Optional<String> optional = Optional.of(email);
        return optional;
    }
}
