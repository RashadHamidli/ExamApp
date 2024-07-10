package com.company.util;

import com.company.entity.Status;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CoreEntityListener {
    @PrePersist
    public void prePersist(CoreEntity entity) {
        entity.setStatus(Status.ACTIVE);
        entity.setCreationDate(LocalDateTime.now());
    }
    @PreUpdate
    public void preUpdate(CoreEntity entity) {
        entity.setModificationDate(LocalDateTime.now());
    }
}
