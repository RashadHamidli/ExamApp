package com.company.repository;

import com.company.entity.Status;
import com.company.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndStatus(@NotBlank(message = "username can not be null or empty!")
                                           @Size(min = 3, max = 30)
                                           String username,
                                           @NotNull(message = "status cannot be null")
                                           Status status);

    boolean existsByUsername(String username);

    boolean existsByUsernameOrEmail(String username, String email);
}
