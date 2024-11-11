package org.example.user_management.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.example.user_management.model.Role;
import org.example.user_management.model.UserRole;
import org.example.user_management.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public int getTotalAdmin() {
        List<Role> usersByRole = roleRepository.findByUserRole(UserRole.ADMIN);
        usersByRole.forEach(role -> log.info(role.getUser().getLastName()));

        return usersByRole.size();
    }
}
