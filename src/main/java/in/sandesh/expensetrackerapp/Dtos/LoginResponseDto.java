package in.sandesh.expensetrackerapp.Dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LoginResponseDto {
    private String username;
     private String message;
     private String token;


    public LoginResponseDto(String token) {
        this.token = token;
    }
}
