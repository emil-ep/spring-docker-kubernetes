package com.innoventes.jukebox.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innoventes.jukebox.constants.ApiConstants;
import com.innoventes.jukebox.exceptions.JukeBoxUnauthorizedException;
import com.innoventes.jukebox.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.innoventes.jukebox.constants.ApiConstants.*;


public class AuthTokenFilter extends OncePerRequestFilter {


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
       return path.contains(ApiConstants.AUTHENTICATION_BASE_PATH)
                || path.contains(SWAGGER_UI_PATH)
                || path.contains(SWAGGER_DOC_PATH)
                || path.contains(SWAGGER_RESOURCES)
                || path.contains(WEB_JARS_SWAGGER_UI_PATH);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String jwt = parseJwt(httpServletRequest);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
            String email = jwtUtils.getSubjectFromJwtToken(jwt);
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            throw new JukeBoxUnauthorizedException("User is unauthenticated to access the resource. Please check your auth token!");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }
        return null;
    }
}
