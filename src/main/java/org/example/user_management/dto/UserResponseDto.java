package org.example.user_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.user_management.model.UserRole;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class UserResponseDto {
    String username;
    UserRole userRole;
}
