package in.sandesh.expensetrackerapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class JwtService {


    @Autowired
    private  JwtEncoder jwtEncoder;

    @Value("${jwt.expiration}")
    private long expirationMs;

    @Value("${jwt.issuer}")
    private String issuer;

    public JwtService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();

        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(now.plus(expirationMs, ChronoUnit.MILLIS))
                .subject(authentication.getName())
                .claim("roles", roles)
                .build();

        // 1. Specify HS256 explicitly in the header
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();

        // 2. Pass both jwsHeader and claims to JwtEncoderParameters
        Jwt jwt = jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claims));

        return jwt.getTokenValue();

    }
}