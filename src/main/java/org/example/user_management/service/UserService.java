package org.example.user_management.service;

import lombok.extern.slf4j.Slf4j;
import org.example.user_management.dto.UserResponseDto;
import org.example.user_management.dto.UserResponseWithDetailsDto;
import org.example.user_management.model.User;
import org.example.user_management.model.UserDetails;
import org.example.user_management.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            log.info("User Not found");
            return null;
        }

        UserResponseDto build = UserResponseDto.builder()
                .username(user.getFirstName() + " " + user.getLastName())
                .userRole(user.getRole().getUserRole())
                .build();
        log.info("response {} ", build);
        return build;
    }

    public UserResponseWithDetailsDto getUserWithDetails(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            log.info("User Not found");
            return null;
        }

        log.info("Fetching User Details");
        UserDetails userDetails = user.getUserDetails();

        UserResponseWithDetailsDto build = UserResponseWithDetailsDto.builder()
                .username(user.getFirstName() + " " + user.getLastName())
                .email(userDetails.getEmail())
                .build();
        log.info("response {} ", build);
        return build;
    }
}

//((HibernateProxy) user.getUserDetails()).getHibernateLazyInitializer().isUninitialized()