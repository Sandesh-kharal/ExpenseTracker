package in.sandesh.expensetrackerapp.controller;


import in.sandesh.expensetrackerapp.Dtos.RegisterRequestDto;
import in.sandesh.expensetrackerapp.Dtos.RegisterResponseDto;
import in.sandesh.expensetrackerapp.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    public AuthController(AuthService authservice) {
        this.authservice = authservice;
    }

    private final AuthService authservice;




    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto){

       RegisterResponseDto registerResponseDto=  authservice.register(registerRequestDto);
       return ResponseEntity.ok(registerResponseDto);




    }


    @GetMapping("/hello")
    public String hello(){
        return "hello sandesh, How are you?";
    }

}
