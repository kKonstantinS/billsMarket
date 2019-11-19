package com.socnetwork.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private JwtTokenProvider provider;

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        if (httpServletRequest.isRequestedSessionIdValid()) {

        }
/*        if (httpServletRequest.containsHeader("token")
        && provider.validateToken(httpServletRequest.getHeader("token"))) {
            httpServletResponse.sendError(HttpServletResponse.SC_FOUND, "Invalid token(status code - 302)");
        }*/
        log.error("Responding with unauthorized error. Message - {}" + " status code 401", e.getMessage());
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
    }
}
