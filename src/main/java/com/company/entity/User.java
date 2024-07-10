package com.company.entity;

import com.company.util.CoreEntity;
import com.company.util.CoreEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@EntityListeners(CoreEntityListener.class)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users", schema = "public")
public class User extends CoreEntity {

    @NotBlank(message = "name can not be null or empty!")
    @Size(min = 3, max = 15)
    @Column(nullable = false)
    String name;

    @NotBlank(message = "surname can not be null or empty!")
    @Size(min = 3, max = 15)
    @Column(nullable = false)
    String surname;

    @NotBlank(message = "username can not be null or empty!")
    @Size(min = 3, max = 30)
    @Column(nullable = false, unique = true)
    String username;

    @NotBlank(message = "email can not be null or empty")
    @Email(message = "enter the correct email!")
    @Column(nullable = false, unique = true)
    String email;

    @Override
    public String toString() {
        return STR."Id: \{id} | name: \{name} | surname: \{surname} | username: \{username} | email: \{email} | creationDate: \{creationDate} | modificationDate: \{modificationDate} | status: \{status}";
    }
}
