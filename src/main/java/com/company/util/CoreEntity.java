package com.company.util;

import com.company.entity.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@SuperBuilder
@EntityListeners(CoreEntityListener.class)
@FieldDefaults(level = AccessLevel.PROTECTED)
public class CoreEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @NotNull(message = "status cannot be null")
    @Column(name = "status", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    Status status;

    @NotNull(message = "creation date cannot be null")
    @Column(name = "creationDate", nullable = false)
    LocalDateTime creationDate;

    @Column(name = "modificationDate")
    LocalDateTime modificationDate;
}
