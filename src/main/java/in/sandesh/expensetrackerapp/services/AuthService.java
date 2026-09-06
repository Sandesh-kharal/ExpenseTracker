package in.sandesh.expensetrackerapp.services;

import in.sandesh.expensetrackerapp.Dtos.RegisterRequestDto;
import in.sandesh.expensetrackerapp.Dtos.RegisterResponseDto;
import in.sandesh.expensetrackerapp.enitites.UserInfo;
import in.sandesh.expensetrackerapp.repository.RoleRepository;
import in.sandesh.expensetrackerapp.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

//    private final RoleRepository roleRepository;
    private final UserRepository userRepository;


    public AuthService(RoleRepository roleRepository, UserRepository userRepository) {
//        this.roleRepository = roleRepository;
        this.userRepository = userRepository;

    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {

        UserInfo user = new UserInfo();
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));



//        // Fix 2: Match role name with DB naming ("ROLE_USER")
//        UserRole role = roleRepository.findByName("ROLE_USER")
//                .orElseThrow(() -> new RuntimeException("Default role 'ROLE_USER' not found"));
//
//        // Fix 3: Ensure roles collection is initialized before adding
//        if (user.getRoles() == null) {
//            user.setRoles(new HashSet<>());
//        }
//        user.getRoles().add(role);

        userRepository.save(user);

        RegisterResponseDto registerResponseDto = new RegisterResponseDto();
        registerResponseDto.setUsername(registerRequestDto.getUsername());
        registerResponseDto.setMessage("User registered successfully");

        // Fix 4: Return the response object
        return registerResponseDto;
    }
}




