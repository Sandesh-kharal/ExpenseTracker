package in.sandesh.expensetrackerapp.controller;

import in.sandesh.expensetrackerapp.Dtos.LoginRequestDto;
import in.sandesh.expensetrackerapp.Dtos.LoginResponseDto;
import in.sandesh.expensetrackerapp.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;


   @PostMapping
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {

        Authentication authenticationRequest = UsernamePasswordAuthenticationToken
                .unauthenticated(loginRequestDto.getUsername(), loginRequestDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationRequest);


        String token = jwtService.generateToken(authentication);
        return new LoginResponseDto(token);

    }


}
