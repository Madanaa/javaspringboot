package com.beginner.beginner.auth.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    private String id;

    private String username;
    private String email;
    private String password; // hashed with BCrypt

    private List<String> roles; // e.g. ["ROLE_USER", "ROLE_SELLER"]

    private Instant createdAt;
    private Instant updatedAt;
}
