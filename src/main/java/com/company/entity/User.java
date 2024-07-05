package com.company.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.StringTemplate.STR;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name can not be null or empty!")
    @Size(min = 3, max = 15)
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "surname can not be null or empty!")
    @Size(min = 3, max = 15)
    @Column(nullable = false)
    private String surname;
    @NotBlank(message = "username can not be null or empty!")
    @Size(min = 3, max = 30)
    @Column(nullable = false, unique = true)
    private String username;
    @NotBlank(message = "email can not be null or empty")
    @Email(message = "enter the correct email!")
    @Column(nullable = false, unique = true)
    private String email;
    @NotNull
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    @NotNull
    private String status;

    @Override
    public String toString() {
        return STR."Id: \{id} | name: \{name} | surname: \{surname} | username: \{username} | email: \{email} | create: \{createAt} | update: \{updateAt} | status: \{status}";
    }
    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
        this.status = "ACTIVE";
    }
    @PreUpdate
    protected void onUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
