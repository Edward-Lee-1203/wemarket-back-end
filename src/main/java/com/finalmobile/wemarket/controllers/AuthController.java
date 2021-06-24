package com.finalmobile.wemarket.controllers;

import com.finalmobile.wemarket.config.sercurity.JwtUtils;
import com.finalmobile.wemarket.models.Shipper;
import com.finalmobile.wemarket.models.User;
import com.finalmobile.wemarket.models.enums.ERole;
import com.finalmobile.wemarket.payload.request.LoginRequest;
import com.finalmobile.wemarket.payload.request.SignupRequest;
import com.finalmobile.wemarket.payload.response.JwtResponse;
import com.finalmobile.wemarket.payload.response.MessageResponse;
import com.finalmobile.wemarket.repository.ShipperRepository;
import com.finalmobile.wemarket.repository.UserRepository;
import com.finalmobile.wemarket.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShipperRepository shipperRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        if (!userRepository.existsByUsername(loginRequest.getUsername())
                && !shipperRepository.existsByUsername(loginRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is not exits!"));
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        Set<String> strRoles = signUpRequest.getRole();

        if (strRoles == null) {
            throw  new RuntimeException("Error: Role is not found.");
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "shipper":
                        Shipper shipper = new Shipper(signUpRequest.getUsername(),
                                encoder.encode(signUpRequest.getPassword()));
                        shipperRepository.save(shipper);
                        break;
                    default:
                        User user = new User(signUpRequest.getUsername(),
                                encoder.encode(signUpRequest.getPassword()));
                        userRepository.save(user);
                }
            });
        }

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}