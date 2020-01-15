package com.socnetwork.security;

import com.socnetwork.exceptions.InvalidJwtAuthenticationException;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserDetailsImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.debug("Filter logger debug");
        logger.info("Filter logger info");
        try {
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                logger.debug("Login attempt.");
                Long userId = tokenProvider.getUserIdFromJWT(jwt);

                UserDetails userDetails = userDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context - ", ex);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if( cookies == null || cookies.length < 1 ) {
            throw new InvalidJwtAuthenticationException("Invalid Token");
        }

        Cookie token = null;
        for( Cookie cookie : cookies ) {
            if( ("token").equals( cookie.getName() ) ) {
                token = cookie;
                break;
            }
        }

        if( token == null || StringUtils.isEmpty( token.getValue() ) ) {
            throw new InvalidJwtAuthenticationException("Invalid Token");
        }

        if (StringUtils.hasText(token.getValue())) {
            return token.getValue();
        }
        return null;
    }
}
