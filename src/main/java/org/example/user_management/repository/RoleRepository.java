package org.example.user_management.repository;

import java.util.List;
import org.example.user_management.model.Role;
import org.example.user_management.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findByUserRole(UserRole role);
}
