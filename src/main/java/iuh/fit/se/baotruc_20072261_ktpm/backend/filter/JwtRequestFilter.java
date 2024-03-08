package iuh.fit.se.baotruc_20072261_ktpm.backend.filter;

import iuh.fit.se.baotruc_20072261_ktpm.backend.authen.UserPrincipal;
import iuh.fit.se.baotruc_20072261_ktpm.backend.models.Token;
import iuh.fit.se.baotruc_20072261_ktpm.backend.service.TokenService;
import iuh.fit.se.baotruc_20072261_ktpm.backend.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import java.io.IOException;
import java.util.*;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService verificationTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
            final String authorizationHeader
                    = request.getHeader("Authorization");

            UserPrincipal user = null;
            Token token = null;


            if (StringUtils.hasText(authorizationHeader) &&
                    authorizationHeader.startsWith("Token ")) {
                String jwt = authorizationHeader.substring(6);

                user = jwtUtil.getUserFromToken(jwt);
                token = verificationTokenService.findByToken(jwt);
            }

            if (null != user && null != token && token.getTokenExpDate().after(new Date())) {

                Set<GrantedAuthority> authorities = new HashSet<>();

                user.getAuthorities().forEach(
                        p -> authorities.add(new SimpleGrantedAuthority((String) p)));

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(user, null, authorities);

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            filterChain.doFilter(request, response);

    }
}