package com.juno.competitionmanagementsystemserver.filter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.juno.competitionmanagementsystemserver.model.AuthUserDetails;
import com.juno.competitionmanagementsystemserver.service.UserDetailsServiceCustomize;
import com.juno.competitionmanagementsystemserver.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserDetailsServiceCustomize userDetailsService;

    public JwtAuthorizationFilter(UserDetailsServiceCustomize userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("auth:" + request.getRequestURI());
        final String header = "Authorization";
        String requestTokenHeader = request.getHeader(header);
        if (requestTokenHeader != null) {
            String jwtToken = requestTokenHeader.substring(7);
            try {
                DecodedJWT payload = JwtUtils.verifyToken(jwtToken);
                if (payload != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    AuthUserDetails userDetails = this.userDetailsService.loadUserByUsername(payload.getPayload());
                    userDetails.setExpiresAt(payload.getExpiresAt());
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, payload, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (Exception e) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(null,
                        null, null);
                authentication.setAuthenticated(false);
                SecurityContextHolder.getContext().setAuthentication(authentication);
                System.out.println("token 验证失败");
            }
        }
        filterChain.doFilter(request, response);
    }
}
